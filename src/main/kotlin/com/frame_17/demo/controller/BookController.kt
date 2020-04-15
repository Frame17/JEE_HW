package com.frame_17.demo.controller

import com.frame_17.demo.controller.model.Book
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

//    @PostMapping("/add-favorite")
//    fun addToFavorites(@RequestBody favorite: Favorite) =
//        favorite.run {
//            bookService.add(title, isbn, author)
//        }
//
//    @GetMapping("/books/favorites")
//    fun favorites() = bookService.favorites()
//
//    @DeleteMapping("/delete-favorite")
//    fun deleteFavorite(@RequestBody book: Book) =
//        book.run {
//            bookService.save(title, isbn, author)
//        }

    @GetMapping(path = ["/book/isbn/{isbn}"])
    fun bookISBN(@PathVariable("isbn") isbn: String) = bookService.bookByISBN(isbn)
}