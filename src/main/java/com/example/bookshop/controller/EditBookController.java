package com.example.bookshop.controller;

import com.example.bookshop.entity.Book;
import com.example.bookshop.entity.Genre;
import com.example.bookshop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 *controller processing edit book page
 */
@Controller
public class EditBookController {
    /**
     * service layer object to work with database entities
     */
    BookService bookService;

    @PostConstruct
    public void init() {
        bookService = new BookService();
    }

    /**
     *
     * @param id id of book being updated
     * @param model initialization object
     * @return view with form of updating book
     */
    @GetMapping("/edit_book/{bookId}")
    public String loadBook(@PathVariable("bookId") Long id, Model model) {

        model.addAttribute("book_for_edit", bookService.findBook(id));
        model.addAttribute("genre", new Genre());
        model.addAttribute("all_authors",bookService.findAllAuthors());
        model.addAttribute("all_genres",bookService.findAllGenres());
        return "edit_book";
    }

    /**
     *
     * @param book object containing form values
     * @return page with table for all books
     */
    @RequestMapping(value = "/edit_book/", method = RequestMethod.POST)
    public String editBook(@ModelAttribute("book_for_edit") final Book book){
        System.out.println("Book EDIT Controller:");
        System.out.println("Book ID:"+book.getBookId());
        System.out.println("Book NAME:"+book.getBookName());
        System.out.println("Book PRICE:"+book.getPrice());
        System.out.println("Book AUTHOR:"+book.getAuthor().getAuthorName());
        System.out.println("Book GENRE:"+book.getGenre().getGenreName());

        bookService.updateBook(book);

        return "redirect:/books";
    }
}
