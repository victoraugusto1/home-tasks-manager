package br.com.hometasksmanager.hometasksmanager.service

import br.com.hometasksmanager.hometasksmanager.domain.User
import br.com.hometasksmanager.hometasksmanager.repository.UserRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class UserServiceImpl (val repository: UserRepository) : UserService {
    override
    fun getUsers(): List<User> {
        return repository.findAll()
    }

    override
    fun getUser(userId: Long): User {
        return repository.findById(userId).orElseThrow { RuntimeException() }
    }

    override
    fun createUser(user: User): User {
        return repository.save(user)
    }

    override
    fun updateUser(userId: Long, user: User): User {
        val myUser: User = repository.findById(userId).orElseThrow { RuntimeException() }
        return repository.save(user.copy( id = myUser.id ))
    }

    override fun getNextId(): Long {
        return (getUsers().count() + 1).toLong()
    }
}