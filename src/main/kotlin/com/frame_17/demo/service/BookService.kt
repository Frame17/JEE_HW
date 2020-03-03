package com.frame_17.demo.service

import com.frame_17.demo.model.BookEntity
import com.frame_17.demo.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BookService @Autowired constructor(private val bookRepository: BookRepository) {

    fun save(title: String, isbn: String, author: String): BookEntity =
        bookRepository.save(BookEntity(title, isbn, author))

    fun allBooks(): MutableIterable<BookEntity> = bookRepository.findAll()

    fun bookById(id: Int) = bookRepository.findByIdOrNull(id) ?: BookEntity("N/A", "N/A", "N/A")
}