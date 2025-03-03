package com.mentor.helloUniverse

import org.springframework.stereotype.Service

private val METADATA = mapOf(
    "version" to "1.0",
    "mode" to "dev"
)

@Service
class GreetingService {
    fun getGreeting(name: String? = null): Greeting? {
        return Greeting(
            message = "Hello, Universe!",
            metadata = METADATA
        )
    }
}