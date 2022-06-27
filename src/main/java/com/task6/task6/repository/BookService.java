package com.task6.task6.repository;

import com.task6.task6.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();

        bookRepository.findAll().forEach(book -> books.add(book));

        return books;
    }

    public void saveOrUpdate(Book book) {
        bookRepository.save(book);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

}
