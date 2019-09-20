package br.com.hometasksmanager.hometasksmanager.repository

import br.com.hometasksmanager.hometasksmanager.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: CrudRepository<User, Long> {

    override fun findAll(): List<User>

}