package br.com.hometasksmanager.hometasksmanager.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
data class User(
        @Id
        var id: Long? = 0L,

        val name: String = ""
)
