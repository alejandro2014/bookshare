package org.bookshare.api.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Library {
    private Set<Book> books;

    public Library() {
        books = new HashSet<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
