package com.frame_17.demo.repository.entity

import javax.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.AUTO) val id: Int?,
    @Column(name = "first_name") val firstName: String,
    @Column(name = "last_name") val lastName: String,
    @Column(name = "username") val username: String,
    @Column(name = "password") val password: String
) {
//    @ManyToMany
//    lateinit var books: BookEntity

    constructor(firstName: String, lastName: String, login: String, password: String)
            : this(null, firstName, lastName, login, password)
}