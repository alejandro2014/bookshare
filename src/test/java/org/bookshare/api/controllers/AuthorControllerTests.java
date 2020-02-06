package org.bookshare.api.controllers;

import org.bookshare.api.model.Author;
import org.bookshare.api.repositories.AuthorRepository;
import org.bookshare.api.services.AuthorService;
import org.junit.Test;
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
        // given
        Author author = Author.builder()
                .name("Miguel")
                .surname("De Unamuno")
                .build();

        when(authorService.getAuthor("Miguel", "De Unamuno")).thenReturn(author);

        // when
        Author returnedAuthor = authorController.getAuthor("Miguel", "De Unamuno");
        
        // then
        assertEquals("Miguel", returnedAuthor.getName());
        assertEquals("De Unamuno", returnedAuthor.getSurname());
    }
}
