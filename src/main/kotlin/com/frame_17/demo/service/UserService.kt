package com.frame_17.demo.service

import com.frame_17.demo.repository.UserRepository
import com.frame_17.demo.repository.entity.UserEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService @Autowired constructor(private val userRepository: UserRepository) {

    fun createUser(firstName: String, lastName: String, login: String, password: String) {
        userRepository.save(UserEntity(firstName, lastName, login, password))
    }

    fun allUsers(): MutableIterable<UserEntity> = userRepository.findAll()

    fun allUsersWithLastName(lastName: String) = userRepository.findByLastName(lastName)

    fun allUsersSubSequence(subSequence: String) = userRepository.findBySubSequence(subSequence)
}