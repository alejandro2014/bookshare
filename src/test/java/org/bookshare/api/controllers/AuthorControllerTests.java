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

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
        // given
        Author author = Author.builder()
                .id(1)
                .name("Miguel")
                .surname("Delibes")
                .build();

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
