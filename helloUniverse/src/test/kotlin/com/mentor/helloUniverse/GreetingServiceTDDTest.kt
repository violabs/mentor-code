package com.mentor.helloUniverse

import org.junit.jupiter.api.Test

class GreetingServiceTDDTest {
    private val greetingService = GreetingService()

    @Test
    fun `getGreeting returns the greeting with default details if inputs not set`() = TestStyle.tdd {
        arrange {
            val expected = Greeting(
                message = "Hello, Universe!",
                metadata = mapOf(
                    "version" to "1.0",
                    "mode" to "dev"
                )
            )

            act {
                val result = greetingService.getGreeting()

                assertion {
                    // assert
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
    fun `getGreeting returns the greeting with custom name if inputs set`() = TestStyle.tdd {
        arrange {
            val expected = Greeting(
                message = "Hello, World!",
                metadata = mapOf(
                    "version" to "1.0",
                    "mode" to "dev"
                )
            )

            act {
                val result = greetingService.getGreeting(name = "World")

                assertion {
                    // assert
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