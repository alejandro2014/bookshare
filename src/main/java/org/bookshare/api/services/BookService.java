package org.bookshare.api.services;

import org.bookshare.api.model.Book;
import org.bookshare.api.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class BookService {
    @Autowired
    private BooksRepository booksRepository;

    public Set<Book> getBooksFromPersonId(Integer personId) {
        //return booksRepository.findById(personId);
        /*//TODO Extract authors to a new table
        Book book1 = Book.builder().author("Fedor Dostoievsky").title("Los hermanos Karamazov").build();
        Book book2 = Book.builder().author("William Shakespeare").title("Hamlet").build();
        Book book3 = Book.builder().author("Gabriel García Márquez").title("Cien años de soledad").build();

        Set<Book> userBooks = new HashSet<>();
        userBooks.add(book1);
        userBooks.add(book2);
        userBooks.add(book3);

        Library library = new Library();
        library.setBooks(userBooks);

        return library;*/
        return null;
    }

    public void addBookToLibrary(Book book, String idLibrary) {
        booksRepository.save(book);
    }
}
