package org.bookshare.api.entities;

import lombok.Data;

import java.util.Set;

@Data
public class Library {
    private Set<Book> books;
}
