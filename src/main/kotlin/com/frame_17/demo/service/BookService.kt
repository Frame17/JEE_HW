package com.frame_17.demo.service

import com.frame_17.demo.repository.BookRepository
import com.frame_17.demo.repository.entity.BookEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BookService @Autowired constructor(private val bookRepository: BookRepository) {

    fun save(title: String, isbn: String, author: String): BookEntity =
        bookRepository.save(BookEntity(title, isbn, author))

//    fun saveFavorite(bookId: Int, userId: Int): FavoriteEntity =
//        favoritesRepository.save(FavoriteEntity(FavoriteEntityId(bookId, userId)))

    fun allBooks(): MutableIterable<BookEntity> = bookRepository.findAll()

//    fun favorites(userId: Int): MutableIterable<FavoriteEntity> = favoritesRepository.findByIdOrNull(FavoriteEntityId())

    fun bookById(id: Int) = bookRepository.findByIdOrNull(id) ?: BookEntity(
        "N/A",
        "N/A",
        "N/A"
    )

    fun bookByISBN(isbn: String) = bookRepository.findBookByIsbn(isbn) ?: BookEntity(
        "N/A",
        "N/A",
        "N/A"
    )

    fun bookByTitle(title: String) = bookRepository.findBookByTitle(title) ?: BookEntity(
        "N/A",
        "N/A",
        "N/A"
    )
}