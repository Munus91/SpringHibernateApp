package com.example.bookshop.controller;

import com.example.bookshop.entity.Book;
import com.example.bookshop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * controller processing page with table of books
 */
@Controller
public class BookController {

    /**
     * service layer object to work with database entities
     */
    BookService bookService;

    /**
     * initialization method
     */
    @PostConstruct
    public void init() {
        bookService = new BookService();
    }

    /**
     *
     * @param model model attribute
     * @return view with table for all books
     */
    @GetMapping("/books")
    public String allBooks(Model model) {
        List<Book> books =bookService.findAllBooks();
        model.addAttribute("all_books", books);
        return "all_books"; //view
    }

    /**
     *
     * @param bookId -id of book being deleted
     * @return view with table for all books
     */
    @PostMapping(value = "/delete_book/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
        System.out.println("DELETING Book with ID : "+ bookId);
        bookService.deleteBooks(bookService.findBook(bookId));
        return "redirect:/books";
    }
}
