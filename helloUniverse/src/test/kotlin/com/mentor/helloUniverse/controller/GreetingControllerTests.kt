package com.mentor.helloUniverse.controller

import com.mentor.helloUniverse.TestStyle
import com.mentor.helloUniverse.domain.Greeting
import com.mentor.helloUniverse.service.GreetingService
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class GreetingControllerTests {
    private val greetingService = mockk<GreetingService>()

    private val greetingController = GreetingController(greetingService)

    @Test
    fun `greet will return default 'Hello Universe!' if no name is provided`() = TestStyle.bdd {
        given("no name provided") {
            every { greetingService.getGreeting() } returns Greeting("Hello Universe!")

            whenever("we call the endpoint with no name provided") {
                val actual = greetingController.greet()

                then("expect 'Hello Universe!'") {
                    val expected = Greeting("Hello Universe!")

                    assert(actual == expected) {
                        """
                            EXPECT: $expected
                            ACTUAL: $actual
                        """.trimIndent()
                    }
                }
            }
        }
    }
}