package br.com.hometasksmanager.hometasksmanager.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.util.*

@Document(collection = "tasks")
data class Task (

        @Id
        val id: Long,

        val subject: String,
        val action: String,
        val dueDate: Date,
        val assignee: User,
        val cost: BigDecimal,
        val finishedAt: Date,
        val createdAt: Date,
        val creator: User,
        val status: String
)
