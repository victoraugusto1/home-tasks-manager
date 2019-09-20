package br.com.hometasksmanager.hometasksmanager.api.controllers

import br.com.hometasksmanager.hometasksmanager.api.controllers.dto.TaskRequest
import br.com.hometasksmanager.hometasksmanager.domain.Task
import br.com.hometasksmanager.hometasksmanager.domain.User
import br.com.hometasksmanager.hometasksmanager.repository.UserRepository
import br.com.hometasksmanager.hometasksmanager.service.TaskService
import br.com.hometasksmanager.hometasksmanager.service.UserService
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
class TaskAdapter(
        var userService: UserService
) {

    fun toDomain(tr: TaskRequest): Task {
        var assignee: User? = null

        if (null != tr.assignee) {
            assignee = userService.getUser(tr.assignee)
        }

        val formatter : DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")


        val creator: User = userService.getUser(tr.creator)

        return Task(null, tr.subject, tr.action, LocalDateTime.parse(tr.dueDate, formatter), assignee, tr.cost, LocalDateTime.parse(tr.finishedAt, formatter), LocalDateTime.parse(tr.createdAt, formatter) , creator, tr.status)
    }
}