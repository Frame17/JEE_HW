package com.frame_17.demo.controller

import com.frame_17.demo.service.BookService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController(private val bookService: BookService) {

    @GetMapping(path = ["/", ""])
    fun index(model: Model): String {
        model.addAttribute("books", bookService.allBooks())
        return "index"
    }
}