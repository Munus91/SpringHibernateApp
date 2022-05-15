package com.example.bookshop.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * entity class for authors table
 * @author nikita
 */
@Entity
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="author_id")
    private Long authorId;
    @Column(name="author_name")
    private String authorName;

    @Column(name="age")
    private int age;

    @OneToMany(mappedBy="author",orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    public Author() {

    }

    public Author(String authorName,List<Book> books) {
        this.authorName=authorName;
        this.books=books;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getAuthorName() {
        return authorName;
    }


    public void setAuthorName(String name) {
        this.authorName = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
