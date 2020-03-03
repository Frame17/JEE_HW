package com.frame_17.demo.model

import javax.persistence.*

@Entity
@Table(name = "books")
data class BookEntity(
    @Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.AUTO) val id: Int?,
    @Column(name = "title") val title: String,
    @Column(name = "isbn") val isbn: String,
    @Column(name = "author") val author: String
) {
    constructor(title: String, isbn: String, author: String) : this(null, title, isbn, author)
}