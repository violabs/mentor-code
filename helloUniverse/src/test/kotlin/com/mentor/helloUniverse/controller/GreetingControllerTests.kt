package com.mentor.helloUniverse.controller

import com.mentor.helloUniverse.TestStyle
import org.junit.jupiter.api.Test

class GreetingControllerTests {
    private val greetingController = GreetingController()

    @Test
    fun `greet will return default 'Hello Universe!' if no name is provided`() = TestStyle.bdd {
        given("no name provided") {
            whenever("we call the endpoint with no name provided") {
                val actual = greetingController.greet()

                then("expect 'Hello Universe!'") {
                    val expected = "Hello Universe!"

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