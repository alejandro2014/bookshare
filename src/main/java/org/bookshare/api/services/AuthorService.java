package org.bookshare.api.services;

import org.bookshare.api.model.Author;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    public Optional<Author> getAuthor(String name, String surname) {
        return Optional.empty();
    }
}
