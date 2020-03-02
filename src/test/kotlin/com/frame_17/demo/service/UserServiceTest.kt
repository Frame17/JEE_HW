package com.frame_17.demo.service

import com.frame_17.demo.model.UserEntity
import com.frame_17.demo.repository.UserRepository
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceTest {

    companion object {
        private val USERS = listOf(UserEntity("Sub", "Zero"), UserEntity("Super", "Man"), UserEntity("Bruce", "Wayne"), UserEntity("Tomas", "Wayne"))
    }

    @Autowired
    lateinit var userService: UserService
    @Autowired
    lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        userRepository.saveAll(USERS)
    }

    @After
    fun tearDown() {
        userRepository.deleteAll()
    }

    @Test
    fun readAllUsers() {
        userService.allUsers().all { USERS.contains(it) }
    }

    @Test
    fun allUsersWithLastName() {
        USERS.filter { it.lastName == "Wayne" }
            .containsAll(userService.allUsersWithLastName("Wayne"))
    }

    @Test
    fun allUsersSubSequence() {
        USERS.filter { it.lastName.contains("er") }
            .containsAll(userService.allUsersSubSequence("er"))
    }
}