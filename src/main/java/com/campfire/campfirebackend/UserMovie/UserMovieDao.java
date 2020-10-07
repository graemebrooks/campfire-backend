package com.campfire.campfirebackend.UserMovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserMovieDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addUserMovie(UserMovie userMovie) {
        String userMovieSql = "INSERT INTO userMovie (id, title, year, director, posterPath, " +
                "hasWatched, watchListed, review, rating, userId) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(userMovieSql, userMovie.getId(), userMovie.getTitle(),
                userMovie.getYear(), userMovie.getDirector(), userMovie.getPosterPath(),
                userMovie.hasWatched(), userMovie.isWatchListed(), userMovie.getReview(),
                userMovie.getRating(), userMovie.getUserId());
    }
}
