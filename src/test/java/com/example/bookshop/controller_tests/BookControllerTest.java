package com.example.bookshop.controller_tests;

import com.example.bookshop.controller.BookController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 *   test for book controller
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BookController.class)
public class BookControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void allbooks() throws Exception {
        ResultActions resultActions= mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(view().name("all_books"));
    }
}
