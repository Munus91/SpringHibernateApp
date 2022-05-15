package com.example.bookshop;

import com.example.bookshop.entity.Author;
import com.example.bookshop.entity.Book;
import com.example.bookshop.entity.Genre;
import com.example.bookshop.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * class for testing hibernate functions in application
 */

public class HibernateMainIntegrationTest {
    private static SessionFactory sessionFactory=HibernateSessionFactoryUtil.getSessionFactory();
    private static Session session;



    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null) sessionFactory.close();
        System.out.println("SessionFactory destroyed");
    }


    @AfterEach
    public void closeSession() {
        if (session != null) session.close();
        System.out.println("Session closed\n");
    }

    @Test
    public void testGetAllBooks(){
        System.out.println("Running GetAllBooks...");
        session = sessionFactory.openSession();
        List<Book> bookList=session.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        Assertions.assertFalse(bookList.isEmpty());
        session.close();

    }

    @Test
    public void testAddBook(){
        System.out.println("Running testAddBook...");
        session = sessionFactory.openSession();

        session.beginTransaction();

        Author author1=new Author();
        author1.setAuthorId(4L);
        author1.setAuthorName("TestAuthor");
        author1.setAge(30);

        Genre genre1=new Genre();
        genre1.setGenreId(4L);
        genre1.setGenreName("TestGenre");

        Book book1=new Book();
        book1.setBookId(3L);
        book1.setBookName("TestBookName");
        book1.setPrice(new BigDecimal(111));
        book1.setAuthor(author1);
        book1.setGenre(genre1);

        Long id = (Long) session.save(book1);
        session.getTransaction().commit();
        Assertions.assertTrue(id > 0);

        session.close();
    }

    @Test
    public void testEditBook(){
        System.out.println("Running testEditBook...");
        session = sessionFactory.openSession();

        session.beginTransaction();
        Author author1=new Author();
        author1.setAuthorId(4L);
        author1.setAuthorName("TestAuthor");
        author1.setAge(30);

        Genre genre1=new Genre();
        genre1.setGenreId(4L);
        genre1.setGenreName("TestGenre");

        Book e_book=new Book();
        e_book.setBookId(1L);
        e_book.setBookName("TestBookName");
        e_book.setPrice(new BigDecimal(111));
        e_book.setAuthor(author1);
        e_book.setGenre(genre1);
        session.update(e_book);
        session.getTransaction().commit();

        Book updatedBook=session.find(Book.class,e_book.getBookId());
        assertEquals("TestBookName", updatedBook.getBookName());
        session.close();
    }

    @Test
    public void testDeleteBook() {
        System.out.println("Running testDeleteBook...");

        session=sessionFactory.openSession();
        session.beginTransaction();

        Long bookId=1L;//ID should be presented in database
        Book book=session.find(Book.class,bookId);
        session.delete(book);
        session.getTransaction().commit();

        Book deletedBook=session.find(Book.class,bookId);
        Assertions.assertNull(deletedBook);
        session.close();
    }

}
