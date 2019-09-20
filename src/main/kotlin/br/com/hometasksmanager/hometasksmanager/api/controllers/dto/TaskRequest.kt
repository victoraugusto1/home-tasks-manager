package br.com.hometasksmanager.hometasksmanager.api.controllers.dto

import java.time.LocalDateTime

class TaskRequest(
        var id: Int?,
        val subject: String,
        val action: String,
        val dueDate: LocalDateTime?,
        val assignee: Long?,
        var cost: Double = 0.0,
        val finishedAt: LocalDateTime?,
        var createdAt: LocalDateTime,
        val creator: Long,
        var status: String?
)