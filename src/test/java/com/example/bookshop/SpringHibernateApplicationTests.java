package com.example.bookshop;

import com.example.bookshop.controller.AddBookController;
import com.example.bookshop.controller.BookController;
import com.example.bookshop.controller.EditBookController;
import com.example.bookshop.utils.HibernateSessionFactoryUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
class SpringHibernateApplicationTests {

	@Autowired
	private BookController bookController;
	@Autowired
	private AddBookController addBookController;
	@Autowired
	private EditBookController editBookController;

	@Test
	void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
		assertThat(addBookController).isNotNull();
		assertThat(editBookController).isNotNull();
	}

}
