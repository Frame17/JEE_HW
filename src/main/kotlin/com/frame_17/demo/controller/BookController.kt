package com.frame_17.demo.controller

import com.frame_17.demo.model.Book
import com.frame_17.demo.service.BookService
import org.springframework.web.bind.annotation.*

@RestController
class BookController(private val bookService: BookService) {
    @PostMapping("/add-book")
    fun addBook(@RequestBody book: Book) =
        book.run {
            bookService.save(title, isbn, author)
        }

    @GetMapping("/books")
    fun books() = bookService.allBooks()

    @GetMapping(path = ["/book/isbn/{isbn}"])
    fun bookISBN(@PathVariable("isbn") isbn: String) = bookService.bookByISBN(isbn)
}