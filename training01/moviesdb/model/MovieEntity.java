package com.moviesdb.model;

import javax.persistence.*;





/**
 * Created by ashwinirajasekar on 5/23/17.
 */
@Entity
@Table(name = "Movie")
public class MovieEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "movieName")
    private String movieName;
    @Column(name = "language")
    private String language;
    @Column(name = "description")
    private String description;
    @Column(name = "rating")
    private double rating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}

