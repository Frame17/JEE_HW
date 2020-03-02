package com.frame_17.demo.controller

import com.frame_17.demo.model.Book
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class IndexController(private val books: MutableList<Book> = mutableListOf()) {

    @GetMapping(path = ["/", ""])
    fun index(model: Model): String {
        model.addAttribute("books", books)
        return "index"
    }

    @GetMapping(path = ["/add-book"])
    fun addBookForm(model: Model): String = "add-book"

    @PostMapping(path = ["/add-book"])
    fun addBook(@ModelAttribute book: Book): String {
        books.add(book)
        return "redirect:/"
    }
}