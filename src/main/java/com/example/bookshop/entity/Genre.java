package com.example.bookshop.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *  entity class for genres table
 * @author nikita
 */
@Entity
@Table(name="genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="genre_id")
    private Long genreId;
    @Column(name="genre_name")
    private String genreName;

    @OneToMany(mappedBy="genre",orphanRemoval = true)

    private List<Book> books = new ArrayList<>();

    public Genre(){

    }

    public Genre(String genreName,List<Book> books){
        this.genreName=genreName;
        this.books=books;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

}

