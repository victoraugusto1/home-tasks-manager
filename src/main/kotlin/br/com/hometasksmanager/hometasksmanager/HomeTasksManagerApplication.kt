package br.com.hometasksmanager.hometasksmanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HomeTasksManagerApplication

fun main(args: Array<String>) {
	runApplication<HomeTasksManagerApplication>(*args)
}
