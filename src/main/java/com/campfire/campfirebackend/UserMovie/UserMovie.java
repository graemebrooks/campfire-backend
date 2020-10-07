package com.campfire.campfirebackend.UserMovie;

import com.campfire.campfirebackend.movie.Movie;

import javax.persistence.Entity;

@Entity
public class UserMovie extends Movie {

    private String userId;
    private boolean hasWatched;
    private boolean watchListed;
    private String review;
    private int rating;

    public UserMovie(String id, String title, int year, String director, String posterPath,
                     boolean hasWatched, boolean watchListed, String review, int rating,
                     String userId) {
        super(id, title, year, director, posterPath);
        this.userId = userId;
        this.hasWatched = hasWatched;
        this.watchListed = watchListed;
        this.review = review;
        this.rating = rating;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean hasWatched() {
        return hasWatched;
    }

    public void setHasWatched(boolean hasWatched) {
        this.hasWatched = hasWatched;
    }

    public boolean isWatchListed() {
        return watchListed;
    }

    public void setWatchListed(boolean watchListed) {
        this.watchListed = watchListed;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
