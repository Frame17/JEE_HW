package com.frame_17.demo.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.AUTO) val id: Int?,
    @Column(name = "first_name") val firstName: String,
    @Column(name = "last_name") val lastName: String
) {
    constructor(firstName: String, lastName: String) : this(null, firstName, lastName)
}