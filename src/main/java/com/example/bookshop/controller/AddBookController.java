package com.example.bookshop.controller;

import com.example.bookshop.entity.Author;
import com.example.bookshop.entity.Book;
import com.example.bookshop.entity.Genre;
import com.example.bookshop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *controller processing adding book page
 */
@Controller
public class AddBookController {

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
     * @param model initialization object
     * @return view with form of adding book
     */
    @GetMapping("/add_book/")
    public String loadBook(Model model) {

        model.addAttribute("book_for_add", new Book());
        model.addAttribute("genre", new Genre());
        model.addAttribute("all_authors",bookService.findAllAuthors());
        model.addAttribute("all_genres",bookService.findAllGenres());

        return "add_book";
    }

    /**
     *
     * @param book object containing form values
     * @return page with table for all books
     */
      @RequestMapping(value = "/add_book/", method = RequestMethod.POST)
      public String addBook(@ModelAttribute("book_for_add") final Book book){

            System.out.println("Book ADD Controller:");
            System.out.println("Book ID:"+book.getBookId());
            System.out.println("Book NAME:"+book.getBookName());
            System.out.println("Book PRICE:"+book.getPrice());
            System.out.println("Book AUTHOR:"+book.getAuthor().getAuthorName());
            System.out.println("Book GENRE:"+book.getGenre().getGenreName());


          bookService.saveBook(book);
          return "redirect:/books";
    }
}
