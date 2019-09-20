package br.com.hometasksmanager.hometasksmanager.service

import br.com.hometasksmanager.hometasksmanager.domain.User
import java.lang.RuntimeException

interface UserService {

    fun getUsers(): List<User>

    @Throws(RuntimeException::class)
    fun getUser(userId: Long): User

    fun createUser(user: User): User

    @Throws(RuntimeException::class)
    fun updateUser(userId: Long, user: User): User
}