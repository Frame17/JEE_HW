package com.frame_17.demo.controller.model

import org.hibernate.validator.constraints.ISBN
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class Book(
    @get:NotBlank val title: String,
    @get:ISBN val isbn: String,
    @get:NotBlank val author: String
)

data class User(
    @get:NotBlank val firstName: String,
    @get:NotBlank val lastName: String,
    val login: String,
    @get:Size(min = 8, max = 20) val password: String
)