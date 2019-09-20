package br.com.hometasksmanager.hometasksmanager.api.controllers

import br.com.hometasksmanager.hometasksmanager.api.controllers.dto.TaskRequest
import br.com.hometasksmanager.hometasksmanager.domain.Task
import br.com.hometasksmanager.hometasksmanager.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException

@RestController
@RequestMapping("/tasks")
class TasksController (var taskService: TaskService,
                       var taskAdapter: TaskAdapter) {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTask(@RequestBody taskRequest: TaskRequest) : Task{
        return taskService.createTask(taskAdapter.toDomain(taskRequest))
    }

    @PutMapping("/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    fun updateTask(@PathVariable("taskId") taskId: Long, @RequestBody body: TaskRequest) : Task {
        return taskService.updateTask(taskId, taskAdapter.toDomain(body))
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getTask(@RequestParam requestParams: Map<String, String>) : List<Task>{
        return taskService.getTasks()
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getTaskById(@PathVariable id: Long) : Task{
        return taskService.getTask(id)
    }
}