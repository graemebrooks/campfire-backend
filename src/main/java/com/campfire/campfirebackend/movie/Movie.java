package com.campfire.campfirebackend.movie;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    // column annotation to change id string length to varchar(36)
    private String id;
    private String title;
    private int year;
    private String director;
    private String posterPath;

    // No arg constructor
    public Movie() {

    }

    public Movie(String id, String title, int year, String director, String posterPath) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.director = director;
        this.posterPath = posterPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
}
