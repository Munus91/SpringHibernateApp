package com.example.bookshop.DAO;

import com.example.bookshop.entity.Author;
import com.example.bookshop.entity.Book;
import com.example.bookshop.entity.Genre;

import java.util.List;

/**
 * interface for interaction with database
 */
public interface BookDAO {
    public Book findBookById(Long id);
    public void save(Book book);
    public void update(Book book);
    public void delete(Book book);
    public List<Book> findAll();

    public List<Author> findAllAuthors();

    public List<Genre> findAllGenres();
}
