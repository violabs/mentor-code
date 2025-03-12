package com.mentor.helloUniverse.domain

data class Greeting(
    val message: String? = null,
    val metadata: Map<String, String>? = null
)