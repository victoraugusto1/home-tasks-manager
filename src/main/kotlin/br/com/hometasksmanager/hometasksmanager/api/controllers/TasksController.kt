package br.com.hometasksmanager.hometasksmanager.api.controllers

import br.com.hometasksmanager.hometasksmanager.api.controllers.dto.TaskRequest
import br.com.hometasksmanager.hometasksmanager.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException

@RestController
@RequestMapping("/tasks")
class TasksController {

    lateinit var taskService: TaskService

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTask(@RequestBody taskRequest: TaskRequest){
        try {
            taskService.createTask(taskRequest)
        } catch (e: RuntimeException){
        }
    }

    @PutMapping("/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    fun updateTask(@PathVariable("taskId") taskId: String, @RequestBody body: TaskRequest){
        println(taskId)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getTask(@RequestParam requestParams: Map<String, String>){
        println(requestParams)
    }
}