package org.bookshare.api.controllers;

import org.bookshare.api.model.Book;
import org.bookshare.api.model.BookRequest;
import org.bookshare.api.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    /*@GetMapping("/books")
    public Library getBooksFromPerson(Integer personId) {
        //return bookService.getBooksFromPersonId(personId);
        return null;
    }*/

    @PostMapping("/book")
    public void addBookToLibrary(@RequestBody BookRequest bookRequest) {
        Book book = bookRequest.getBook();
        String idLibrary = bookRequest.getIdLibrary();

        bookService.addBookToLibrary(book, idLibrary);
    }
}
