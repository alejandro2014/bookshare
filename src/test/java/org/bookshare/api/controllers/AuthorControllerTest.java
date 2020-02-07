package org.bookshare.api.controllers;

import org.bookshare.api.model.Author;
import org.bookshare.api.services.AuthorService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthorControllerTest {

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
    public void returnsAuthor_ifUserExists() throws Exception {
        // given
        Author author = Author.builder()
                .id(1)
                .name("Miguel")
                .surname("Delibes")
                .build();

        when(authorService.getAuthor("miguel", "delibes"))
                .thenReturn(Optional.of(author));

        // when
        mockMvc.perform(MockMvcRequestBuilders
                .get("/author/delibes/miguel")
                .content("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Miguel")))
                .andExpect(jsonPath("$.surname", is("Delibes")));
    }

    @Test
    public void returns404_ifUserDoesntExist() throws Exception {
        // given
        Optional<Author> author = Optional.empty();

        when(authorService.getAuthor("miguel", "delibes")).thenReturn(author);

        // when
        mockMvc.perform(MockMvcRequestBuilders
                .get("/author/delibes/miguel")
                .content("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Miguel")))
                .andExpect(jsonPath("$.surname", is("Delibes")));
    }
}
