package com.msawchuk.appals

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AppalsApplication

fun main(args: Array<String>) {
	runApplication<AppalsApplication>(*args)
}
