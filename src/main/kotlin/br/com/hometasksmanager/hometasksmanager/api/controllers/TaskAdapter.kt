package br.com.hometasksmanager.hometasksmanager.api.controllers

import br.com.hometasksmanager.hometasksmanager.api.controllers.dto.TaskRequest
import br.com.hometasksmanager.hometasksmanager.domain.Task
import br.com.hometasksmanager.hometasksmanager.domain.User
import br.com.hometasksmanager.hometasksmanager.repository.UserRepository
import br.com.hometasksmanager.hometasksmanager.service.TaskService
import br.com.hometasksmanager.hometasksmanager.service.UserService
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
class TaskAdapter(
        var userService: UserService
) {

    fun toDomain(tr: TaskRequest): Task {
        var assignee: User? = null
        var creator: User? = null
        var dueDate: LocalDate? = null
        var finishedAt: LocalDate? = null
        var createdAt: LocalDate? = null

        if (null != tr.assignee) {
            assignee = userService.getUser(tr.assignee)
        }

        val formatter : DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

        if (null != tr.creator) {
            creator = userService.getUser(tr.creator)
        }

        if (tr.dueDate != null) {
            dueDate = LocalDate.parse(tr.dueDate, formatter)
        }

        if (tr.finishedAt != null) {
            finishedAt = LocalDate.parse(tr.finishedAt, formatter)
        }

        if (tr.createdAt != null) {
            createdAt = LocalDate.parse(tr.createdAt, formatter)
        }


        return Task(null, tr.subject, tr.action, dueDate, assignee, tr.cost, finishedAt, createdAt, creator, tr.status)
    }
}