package org.bookshare.api.controllers;

import org.bookshare.api.model.Author;
import org.bookshare.api.repositories.AuthorRepository;
import org.bookshare.api.services.AuthorService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {AuthorService.class})
@RunWith(MockitoJUnitRunner.class)
public class AuthorControllerTests {

    @Mock
    private AuthorService authorService;

    @InjectMocks
    private AuthorController authorController;

    @Test
    public void theControllerGetsAnExistentAuthor() {
        final String AUTHOR_NAME = "Miguel";
        final String AUTHOR_SURNAME = "De Unamuno";

        // given
        Author author = Author.builder()
                .name(AUTHOR_NAME)
                .surname(AUTHOR_SURNAME)
                .build();

        when(authorService.getAuthor(AUTHOR_NAME, AUTHOR_SURNAME)).thenReturn(author);

        // when
        Author returnedAuthor = authorController.getAuthor(AUTHOR_NAME, AUTHOR_SURNAME);
        
        // then
        assertEquals(AUTHOR_NAME, returnedAuthor.getName());
        assertEquals(AUTHOR_SURNAME, returnedAuthor.getSurname());
    }
}
