package br.com.hometasksmanager.hometasksmanager.api.controllers

import br.com.hometasksmanager.hometasksmanager.domain.User
import br.com.hometasksmanager.hometasksmanager.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin( origins = ["*"])
@RequestMapping("/users")
class UsersController (var userService: UserService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody user: User) {
        user.id = userService.getNextId()
        userService.createUser(user)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun getUsers() : List<User> {
        return userService.getUsers()
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun getUserById(@PathVariable id: Long) : User {
        return userService.getUser(id)
    }
}