package com.frame_17.demo.controller

import com.frame_17.demo.model.Book
import com.frame_17.demo.service.BookService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class IndexController(private val bookService: BookService) {

    @GetMapping(path = ["/", ""])
    fun index(model: Model): String {
        model.addAttribute("books", bookService.allBooks())
        return "index"
    }

    @GetMapping(path = ["/add-book"])
    fun addBookForm(model: Model): String = "add-book"

    @PostMapping(path = ["/add-book"])
    fun addBook(@ModelAttribute book: Book): String =
        book.run {
            bookService.save(title, isbn, author)
        }.let {
            "redirect:/"
        }

    @GetMapping(path = ["/book/{id}"])
    fun book(model: Model, @PathVariable("id") id: Int): String {
        model.addAttribute("book", bookService.bookById(id))
        return "book"
    }

    @GetMapping(path = ["/book/isbn/{isbn}"])
    fun bookISBN(model: Model, @PathVariable("isbn") isbn: String): String {
        model.addAttribute("book", bookService.bookByISBN(isbn))
        return "book"
    }

    @GetMapping(path = ["/book/title/{title}"])
    fun bookTitle(model: Model, @PathVariable("title") title: String): String {
        model.addAttribute("book", bookService.bookByTitle(title))
        return "book"
    }
}