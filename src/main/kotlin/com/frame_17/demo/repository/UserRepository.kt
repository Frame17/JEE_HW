package com.frame_17.demo.repository

import com.frame_17.demo.model.UserEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<UserEntity, Int> {

    @Query("select u from UserEntity u where u.lastName = ?1")
    fun findByLastName(lastName: String) : List<UserEntity>

    @Query("SELECT u FROM UserEntity u WHERE u.lastName LIKE %?1% OR u.firstName LIKE %?1%")
    fun findBySubSequence(subSequence: String) : List<UserEntity>
}