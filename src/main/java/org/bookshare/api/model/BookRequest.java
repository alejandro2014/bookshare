package org.bookshare.api.model;

import lombok.Data;

@Data
public class BookRequest {
    private String idLibrary;
    private Book book;
}
