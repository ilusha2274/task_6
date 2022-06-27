package com.task6.task6.controllers;

import com.task6.task6.domain.Book;
import com.task6.task6.repository.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/{id}")
    public String printBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));

        return "book";
    }

    @PostMapping("/{id}")
    public String updateBook(@PathVariable Long id, Model model, String textBook){
        Book book = bookService.getBookById(id);

        book.setText(textBook);
        bookService.saveOrUpdate(book);

        model.addAttribute("book", book);

        return "book";
    }
}
