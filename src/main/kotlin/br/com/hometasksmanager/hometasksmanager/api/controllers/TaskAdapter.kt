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

        val formatter : DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

        if (null != tr.assignee) {
            assignee = userService.getUser(tr.assignee)
        }

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

    fun fromDomain(t: Task): TaskRequest {
        var assignee: Long? = null
        var creator: Long? = null
        var dueDate: String? = null
        var finishedAt: String? = null
        var createdAt: String? = null

        val formatter : DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

        if (null != t.assignee) {
            assignee = t.assignee.id
        }

        if (null != t.creator) {
            creator = t.creator.id
        }

        if (t.dueDate != null) {
            dueDate = formatter.format(t.dueDate)
        }

        if (t.finishedAt != null) {
            finishedAt = formatter.format(t.finishedAt)
        }

        if (t.createdAt != null) {
            createdAt = formatter.format(t.createdAt)
        }

        return TaskRequest(null, t.subject, t.action, dueDate, assignee, t.cost, finishedAt, createdAt, creator, t.status)
    }
}