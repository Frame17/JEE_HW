package com.frame_17.demo.service

import com.frame_17.demo.model.UserEntity
import com.frame_17.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService @Autowired constructor(private val userRepository: UserRepository) {

    fun createUser(firstName: String, lastName: String, email: String) {
        userRepository.save(UserEntity(firstName, lastName))
    }

    fun allUsers() = userRepository.findAll()

    fun allUsersWithLastName(lastName: String) = userRepository.findByLastName(lastName)

    fun allUsersSubSequence(subSequence: String) = userRepository.findBySubSequence(subSequence)
}