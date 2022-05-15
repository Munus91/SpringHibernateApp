package com.example.bookshop.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * entity class for books table
 * @author nikita
 */
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="book_id")
    private Long bookId;
    @Column(name="book_name")
    private String bookName;
    @Column(name="price")
    private BigDecimal price;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="author_id",insertable = false, updatable = false)
    private Author author;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="genre_id",insertable = false, updatable = false)
    private Genre genre;

    public Book() {

    }
    public Book(String bookName, BigDecimal price,Genre genre ) {
        this.bookName=bookName;
        this.price=price;
        this.genre=genre;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}