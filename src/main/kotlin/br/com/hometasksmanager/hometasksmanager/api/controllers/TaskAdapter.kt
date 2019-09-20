package br.com.hometasksmanager.hometasksmanager.api.controllers

import br.com.hometasksmanager.hometasksmanager.api.controllers.dto.TaskRequest
import br.com.hometasksmanager.hometasksmanager.domain.Task
import br.com.hometasksmanager.hometasksmanager.domain.User
import br.com.hometasksmanager.hometasksmanager.repository.UserRepository
import java.time.LocalDateTime

class TaskAdapter() {

    lateinit var userRepository: UserRepository

    fun toDomain(taskRequest: TaskRequest){
        var assigneeUser: User
        try {
            assigneeUser = userRepository.findById(taskRequest.assignee)
        }catch (e){
            // user not found
        }

        Task(
                null, taskRequest.subject, taskRequest.action,
                LocalDateTime.parse(taskRequest.dueDate), assigneeUser, taskRequest.cost,
                null, LocalDateTime.now(), null, "pending")
    }
}