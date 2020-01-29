package org.bookshare.api.repositories;

import org.bookshare.api.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BooksRepository extends JpaRepository<Book, Long> {
    Set<Book> findById(Integer personId);
}
