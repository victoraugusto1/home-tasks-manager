package br.com.hometasksmanager.hometasksmanager.service

import br.com.hometasksmanager.hometasksmanager.domain.Task
import br.com.hometasksmanager.hometasksmanager.repository.TaskRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class TaskServiceImpl (
    val repository : TaskRepository
) : TaskService {

    override
    fun createTask(task: Task): Task {
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
}