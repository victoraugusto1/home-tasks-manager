package br.com.hometasksmanager.hometasksmanager.api.controllers

import br.com.hometasksmanager.hometasksmanager.api.controllers.dto.TaskRequest
import br.com.hometasksmanager.hometasksmanager.domain.Task
import br.com.hometasksmanager.hometasksmanager.domain.User
import br.com.hometasksmanager.hometasksmanager.repository.UserRepository
import br.com.hometasksmanager.hometasksmanager.service.TaskService
import br.com.hometasksmanager.hometasksmanager.service.UserService
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class TaskAdapter(
        var userService: UserService
) {

    fun toDomain(tr: TaskRequest): Task {
        var assignee: User? = null

        if (null != tr.assignee) {
            assignee = userService.getUser(tr.assignee)
        }

        val creator: User = userService.getUser(tr.creator)

        return Task(null, tr.subject, tr.action, tr.dueDate, assignee, tr.cost, tr.finishedAt, tr.createdAt, creator, tr.status)
    }
}