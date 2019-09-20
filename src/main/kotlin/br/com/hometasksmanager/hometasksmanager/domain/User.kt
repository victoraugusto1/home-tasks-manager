package br.com.hometasksmanager.hometasksmanager.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
data class User(
        val name: String,

        @Id
        val id: Long
)
