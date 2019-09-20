package br.com.hometasksmanager.hometasksmanager.service

import br.com.hometasksmanager.hometasksmanager.domain.Task
import java.lang.RuntimeException

interface TaskService {

    fun getTasks(): List<Task>

    @Throws(RuntimeException::class)
    fun getTask(taskId: Long): Task

    fun createTask(task: Task): Task

    @Throws(RuntimeException::class)
    fun updateTask(taskId: Long, task: Task): Task
}