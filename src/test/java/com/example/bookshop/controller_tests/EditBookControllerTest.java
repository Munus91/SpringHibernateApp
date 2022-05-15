package com.example.bookshop.controller_tests;

import com.example.bookshop.controller.EditBookController;
import org.testng.annotations.Test;
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
 *  test for edit book controller
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = EditBookController.class)
public class EditBookControllerTest {

    @Autowired
    MockMvc mockMvc;

    /**
     * calling edit for the first book in table
     * @throws Exception
     */
    @Test
    public void loadBook() throws Exception{

        ResultActions resultActions=mockMvc.perform(get("/edit_book/{bookId}",1))
                .andExpect(status().isOk())
                .andExpect(view().name("edit_book"));
    }

}
