package org.bookshare.api.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "books")
@Data
@Builder
public class Book {
    @Id
    @GeneratedValue
    private String id;

    private String title;
    private String author;
}
