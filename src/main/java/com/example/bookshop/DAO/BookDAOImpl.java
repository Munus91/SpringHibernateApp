package com.example.bookshop.DAO;

import com.example.bookshop.entity.Author;
import com.example.bookshop.entity.Book;
import com.example.bookshop.entity.Genre;
import com.example.bookshop.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * implementation of interface for interaction with database
 */
public class BookDAOImpl implements BookDAO {
    /**
     * sessionfactory object
     */
    private final SessionFactory factory= HibernateSessionFactoryUtil.getSessionFactory();

    /**
     *
     * @param id
     * @return
     */

    public Book findBookById(Long id) {
        Book book;
        Session sess = factory.openSession();
        Transaction tx=null;
        try{
            tx = sess.beginTransaction();
            book=sess.get(Book.class,id);

            tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            sess.close();
        }
        return book;
    }

    /**
     *
     * @param book
     */
    public void save (Book book) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        String sql = String.format("INSERT INTO books (book_id,book_name,price,author_id,genre_id) VALUES('%o','%s','%s','%o','%o');",book.getBookId(), book.getBookName(),book.getPrice(),book.getAuthor().getAuthorId(),book.getGenre().getGenreId());
        session.createSQLQuery(sql).executeUpdate();
        tx1.commit();
        session.close();
    }

    /**
     *
     * @param book
     */
    public void update (Book book) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(book);
        tx1.commit();
        session.close();
    }

    /**
     *
     * @param book
     */
    public void delete(Book book) {
        Session session = factory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(book);
        tx1.commit();
        session.close();
    }

    /**
     *
     * @return
     */

    public List<Book> findAll(){
        String SQL= "SELECT b FROM Book b";
        Session session = factory.openSession();
        Query query = session.createQuery(SQL);
        List<Book> books = (List<Book>) query.list();
        return books;
    }

    /**
     *
     * @return
     */
    public List<Author> findAllAuthors(){
        Session session = factory.openSession();
        List<Author> authors=session.createQuery("SELECT a FROM Author a", Author.class).getResultList();
        return  authors;

    }

    /**
     *
     * @return
     */
    public List<Genre> findAllGenres(){
        Session session = factory.openSession();
        List<Genre> genres=session.createQuery("SELECT g FROM Genre g", Genre.class).getResultList();
        return  genres;
    }
    }
