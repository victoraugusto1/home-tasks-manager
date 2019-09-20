package br.com.hometasksmanager.hometasksmanager.api.controllers.dto

class TaskRequest(
        var id: Int?,
        val subject: String,
        val action: String,
        val dueDate: String?,
        val assignee: Long?,
        var cost: Int = 0,
        val creator: String,
        var status: String?,
        var createdAt: String?
)