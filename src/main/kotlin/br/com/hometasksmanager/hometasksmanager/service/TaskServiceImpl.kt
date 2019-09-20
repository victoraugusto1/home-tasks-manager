package br.com.hometasksmanager.hometasksmanager.service

import br.com.hometasksmanager.hometasksmanager.domain.Task
import br.com.hometasksmanager.hometasksmanager.repository.TaskRepository
import com.sun.jna.platform.win32.Netapi32Util.getUsers
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class TaskServiceImpl (val repository : TaskRepository) : TaskService {
    override
    fun createTask(task: Task): Task {
        task.id = getNextId()
        return repository.save(task)
    }

    override
    fun updateTask(taskId: Long, task: Task): Task {
        val myTask: Task = repository.findById(taskId).orElseThrow { RuntimeException() }
        return repository.save(task.copy( id = myTask.id ))
    }

    override
    fun getTasks(): List<Task> {
        return repository.findAll()
    }

    override
    fun getTask(taskId: Long): Task {
        return repository.findById(taskId).orElseThrow { RuntimeException() }
    }

    override fun getNextId(): Long {
        return (getTasks().count() + 1).toLong()
    }
}