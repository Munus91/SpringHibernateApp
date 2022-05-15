package com.example.bookshop.service;

import com.example.bookshop.DAO.BookDAOImpl;
import com.example.bookshop.entity.Author;
import com.example.bookshop.entity.Book;
import com.example.bookshop.entity.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service layer class to interact with database entities
 */
public class BookService {
    private BookDAOImpl booksDao= new BookDAOImpl();

    public BookService() {

    }

    public Book findBook(Long id) {
        return booksDao.findBookById(id);
    }

    public void saveBook(Book book) {
        booksDao.save(book);
    }

    public void deleteBooks(Book book) {
        booksDao.delete(book);
    }

    public void updateBook(Book book) {
        booksDao.update(book);
    }

    public List<Book> findAllBooks(){
        return booksDao.findAll();
    }

    public List<Author> findAllAuthors(){
        return booksDao.findAllAuthors();
    }
    public List<Genre> findAllGenres(){
        return booksDao.findAllGenres();
    }

}
