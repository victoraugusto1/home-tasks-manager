package br.com.hometasksmanager.hometasksmanager.api.controllers

import br.com.hometasksmanager.hometasksmanager.api.controllers.dto.TaskRequest
import br.com.hometasksmanager.hometasksmanager.domain.Task
import br.com.hometasksmanager.hometasksmanager.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException
import kotlin.streams.toList

@RestController
@CrossOrigin( origins = ["*"])
@RequestMapping("/tasks")
class TasksController (var taskService: TaskService,
                       var taskAdapter: TaskAdapter) {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTask(@RequestBody taskRequest: TaskRequest) : TaskRequest {
        return taskAdapter.fromDomain(taskService.createTask(taskAdapter.toDomain(taskRequest)))
    }

    @PutMapping("/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    fun updateTask(@PathVariable("taskId") taskId: Long, @RequestBody body: TaskRequest) : TaskRequest {
        return taskAdapter.fromDomain(taskService.updateTask(taskId, taskAdapter.toDomain(body)))
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getTask(@RequestParam requestParams: Map<String, String>) : List<TaskRequest>{
        return taskService.getTasks().stream().map { tr -> taskAdapter.fromDomain(tr) }.toList()
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getTaskById(@PathVariable id: Long) : TaskRequest{
        return taskAdapter.fromDomain(taskService.getTask(id))
    }
}