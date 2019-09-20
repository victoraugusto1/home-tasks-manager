package br.com.hometasksmanager.hometasksmanager.api.controllers

import br.com.hometasksmanager.hometasksmanager.api.controllers.dto.TaskRequest
import br.com.hometasksmanager.hometasksmanager.domain.Task
import br.com.hometasksmanager.hometasksmanager.repository.UserRepository
import java.time.LocalDateTime

class TaskAdapter() {

    lateinit var userRepository: UserRepository

    fun toDomain(taskRequest: TaskRequest){
        val assigneeUser = if (taskRequest.assignee != null) userRepository.findById(taskRequest.assignee) else null
        Task(null, taskRequest.subject, taskRequest.action, LocalDateTime.parse(taskRequest.dueDate), assigneeUser, )
    }
}