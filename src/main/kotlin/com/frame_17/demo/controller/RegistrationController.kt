package com.frame_17.demo.controller

import com.frame_17.demo.controller.model.User
import com.frame_17.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class RegistrationController @Autowired constructor(
    private val userService: UserService
) {

    @PostMapping("register")
    fun register(@Valid @RequestBody user: User) : ResponseEntity<Unit> =
        user.run {
            if (!user.login.matches(Regex("^[a-zA-Z0-9]+$"))) {
                return ResponseEntity.badRequest().build()
            }
            userService.createUser(firstName, lastName, login, password)
            ResponseEntity.ok().build()
        }
}