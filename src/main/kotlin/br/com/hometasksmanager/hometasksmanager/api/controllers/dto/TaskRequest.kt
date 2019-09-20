package br.com.hometasksmanager.hometasksmanager.api.controllers.dto

import java.time.LocalDateTime

class TaskRequest(
        var id: Int?,
        val subject: String,
        val action: String,
        val dueDate: String?,
        val assignee: Long?,
        var cost: Double = 0.0,
        val finishedAt: String?,
        var createdAt: String?,
        val creator: Long,
        var status: String?
)