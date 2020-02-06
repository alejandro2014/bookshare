package org.bookshare.api.controllers;

import org.bookshare.api.model.Author;
import org.bookshare.api.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    public Author getAuthor(String name, String surname) {
        return authorService.getAuthor(name, surname);
    }
}
