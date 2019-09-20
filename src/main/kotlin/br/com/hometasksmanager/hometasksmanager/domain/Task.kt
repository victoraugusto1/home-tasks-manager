package br.com.hometasksmanager.hometasksmanager.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Document(collection = "tasks")
data class Task (

        @Id
        val id: Long = 0L,

        val subject: String = "",
        val action: String = "",
        val dueDate: LocalDateTime? = null,
        val assignee: User? = null,
        val cost: Double = 0.0,
        val finishedAt: Date? = null,
        val createdAt: LocalDateTime = LocalDateTime.now(),
        val creator: User? = null,
        val status: String = "pending"
)
