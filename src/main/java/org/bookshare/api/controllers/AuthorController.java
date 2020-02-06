package org.bookshare.api.controllers;

import org.bookshare.api.model.Author;
import org.bookshare.api.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/author/{surname}/{name}")
    public Author getAuthor(@PathVariable String name, @PathVariable String surname) {
        return authorService.getAuthor(name, surname);
    }
}
