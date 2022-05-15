package com.example.bookshop.controller_tests;

import com.example.bookshop.controller.AddBookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * test for add book controller
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AddBookController.class)
public class AddBookControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void loadBook() throws Exception{
        ResultActions resultActions=mockMvc.perform(get("/add_book/"))
                .andExpect(status().isOk())
                .andExpect(view().name("add_book"));
    }

}
