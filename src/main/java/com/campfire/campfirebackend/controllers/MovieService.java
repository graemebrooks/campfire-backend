package com.campfire.campfirebackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieDao movieDao;

    public List<Movie> getAllMovies() {
        return movieDao.getAllMovies();
    }

    public Optional<Movie> getMovie(String id) {
        return Optional.ofNullable(movieDao.getMovie(id));
    }

    public void addMovie(Movie movie) {
        movieDao.addMovie(movie);
    }

    public void updateMovie(String id, Movie movie) {
        movieDao.updateMovie(id, movie);
    }

    public void deleteMovie(String id) {
        movieDao.deleteMovie(id);
    }
}
