package com.frame_17.demo.controller

import com.frame_17.demo.controller.model.User
import com.frame_17.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RegistrationController @Autowired constructor(
    private val userService: UserService
) {

    @PostMapping("register")
    fun register(@RequestBody user: User) : Unit =
        user.run {
            userService.createUser(firstName, lastName, login, password)
        }
}