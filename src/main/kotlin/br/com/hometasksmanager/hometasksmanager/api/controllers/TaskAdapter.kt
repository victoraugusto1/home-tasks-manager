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

        if (null != tr.assignee) {
            assignee = userService.getUser(tr.assignee)
        }

        val formatter : DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")


        val creator: User = userService.getUser(tr.creator)

        return Task(null, tr.subject, tr.action, LocalDate.parse(tr.dueDate, formatter), assignee, tr.cost, LocalDate.parse(tr.finishedAt, formatter), LocalDate.parse(tr.createdAt, formatter) , creator, tr.status)
    }
}