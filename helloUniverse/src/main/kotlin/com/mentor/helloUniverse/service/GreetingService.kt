package com.mentor.helloUniverse.service

import com.mentor.helloUniverse.domain.Greeting
import org.springframework.stereotype.Service

private val METADATA = mapOf(
    "version" to "1.0",
    "mode" to "dev"
)


@Service
class GreetingService {
    fun getGreeting(name: String = "Universe"): Greeting {
        return Greeting(
            message = "Hello, $name!",
            metadata = METADATA
        )
    }
}