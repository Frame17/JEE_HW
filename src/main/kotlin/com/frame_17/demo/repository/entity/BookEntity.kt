package com.frame_17.demo.repository.entity

import javax.persistence.*

@Entity
@Table(name = "books")
data class BookEntity(
    @Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.AUTO) val id: Int?,
    @Column(name = "title") val title: String,
    @Column(name = "isbn") val isbn: String,
    @Column(name = "author") val author: String
) {
//    @ManyToMany
//    lateinit var users: UserEntity

    constructor(title: String, isbn: String, author: String) : this(null, title, isbn, author)
}