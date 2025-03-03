package com.mentor.helloUniverse

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloUniverseApplication

fun main(args: Array<String>) {
	runApplication<HelloUniverseApplication>(*args)
}
