package br.com.hometasksmanager.hometasksmanager.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Document(collection = "tasks")
data class Task (
        @Id
        var id: Long? = 0L,

        val subject: String = "",
        val action: String = "",
        val dueDate: LocalDate? = null,
        val assignee: User? = null,
        val cost: Double = 0.0,
        val finishedAt: LocalDate? = null,
        val createdAt: LocalDate = LocalDate.now(),
        val creator: User? = null,
        val status: String? = "pending"
)
