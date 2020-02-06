package org.bookshare.api.controllers;

import org.bookshare.api.model.Author;
import org.bookshare.api.services.AuthorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthorControllerTests {

    @Mock
    private AuthorService authorService;

    @InjectMocks
    private AuthorController authorController;

    private MockMvc mockMvc;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(authorController)
                .build();
    }

    @Test
    public void theControllerGetsAnExistentAuthor() throws Exception {
        final String AUTHOR_NAME = "miguel";
        final String AUTHOR_SURNAME = "delibes";

        // given
        Author author = Author.builder()
                .name(AUTHOR_NAME)
                .surname(AUTHOR_SURNAME)
                .build();

        when(authorService.getAuthor(AUTHOR_NAME, AUTHOR_SURNAME)).thenReturn(author);

        // when
        mockMvc.perform(MockMvcRequestBuilders
                .get("/author/delibes/miguel")
                .content("application/json"))
                .andExpect(status().isOk());
    }
}
