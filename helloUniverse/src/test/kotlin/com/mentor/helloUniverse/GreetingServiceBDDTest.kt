package com.mentor.helloUniverse

import org.junit.jupiter.api.Test

class GreetingServiceBDDTest {
    private val greetingService = GreetingService()

    @Test
    fun `getGreeting returns the greeting with default details if inputs not set`() = TestStyle.bdd {
        given("a request without a name") {
            whenever("we call for a greeting") {
                val result = greetingService.getGreeting()

                then("expect default 'Hello Universe!' with metadata") {
                    val expected = Greeting(
                        message = "Hello, Universe!",
                        metadata = mapOf(
                            "version" to "1.0",
                            "mode" to "dev"
                        )
                    )

                    assert(result == expected) {
                        """
                            EXPECT: $expected
                            ACTUAL: $result
                        """.trimIndent()
                    }
                }
            }
        }
    }

    @Test
    fun `getGreeting returns the greeting with custom name if inputs set`() = TestStyle.bdd {
        given("a request with a name 'World'") {
            whenever("we call for a greeting") {
                val result = greetingService.getGreeting(name = "World")

                then("expect returned 'Hello World!' with metadata") {
                    val expected = Greeting(
                        message = "Hello, World!",
                        metadata = mapOf(
                            "version" to "1.0",
                            "mode" to "dev"
                        )
                    )

                    assert(result == expected) {
                        """
                        EXPECT: $expected
                        ACTUAL: $result
                        """.trimIndent()
                    }
                }
            }
        }
    }
}