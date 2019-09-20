package br.com.hometasksmanager.hometasksmanager.repository

import br.com.hometasksmanager.hometasksmanager.domain.Task
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : CrudRepository<Task, Long> {
    override fun findAll(): List<Task>
}