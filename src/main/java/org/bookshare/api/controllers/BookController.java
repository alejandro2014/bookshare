package org.bookshare.api.controllers;

import org.bookshare.api.entities.Book;
import org.bookshare.api.entities.Library;
import org.bookshare.api.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public Library getBooksFromPerson(Integer personId) {
        //return bookService.getBooksFromPersonId(personId);
        return null;
    }

    @PostMapping("/book")
    public void addBookToLibrary(Book book, Library library) {
        bookService.addBookToLibrary(book, library);
    }
}
