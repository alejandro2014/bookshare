package org.bookshare.api.controllers;

import org.bookshare.api.entities.Book;
import org.bookshare.api.entities.Library;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @GetMapping("/books")
    public List<Book> getBooksFromLibrary(Library library) {
        return null;
    }
}
