package com.task6.task6.controllers;

import com.task6.task6.domain.Book;
import com.task6.task6.repository.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class HomeController {

    @Autowired
    BookService bookService;

    static final private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    @GetMapping("/")
    public String printHome(Model model) {
        model.addAttribute("listBook", bookService.getAllBooks());

        return "home";
    }

    @PostMapping("/add")
    public String workWithBooks(Model model, String name) {
        bookService.saveOrUpdate(new Book(name, dateTimeFormatter.format(LocalDateTime.now()), ""));

        model.addAttribute("listBook", bookService.getAllBooks());

        return "home";
    }

    @PostMapping("/delete")
    public String deleteBook(Model model, Long id) {
        bookService.delete(id);

        model.addAttribute("listBook", bookService.getAllBooks());

        return "home";
    }

}
