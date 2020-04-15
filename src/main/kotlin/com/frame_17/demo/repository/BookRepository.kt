package com.frame_17.demo.repository

import com.frame_17.demo.repository.entity.BookEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
interface BookRepository: CrudRepository<BookEntity, Int> {

    fun findBookByIsbn(isbn: String): BookEntity?

    fun findBookByTitle(title: String): BookEntity?

//    fun findByUserId(userId: String): List<BookEntity>
}