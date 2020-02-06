package org.bookshare.api.repositories;

import org.bookshare.api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, String> {

}
