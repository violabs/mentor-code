package com.mentor.helloUniverse.controller

import com.mentor.helloUniverse.domain.Greeting
import com.mentor.helloUniverse.service.GreetingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("greeting")
class GreetingController(
    @Autowired val greetingService: GreetingService
) {

    @GetMapping
    fun greet(): Greeting? {
        return greetingService.getGreeting()
    }
}