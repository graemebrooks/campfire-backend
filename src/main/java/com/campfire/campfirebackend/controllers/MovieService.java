package com.campfire.campfirebackend.controllers;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

    private List<Movie> movies = Arrays.asList(
            new Movie("movie-1", "Jurassic Park", 1993),
            new Movie("movie-2", "Her", 2013),
            new Movie("movie-3", "Get Out", 2017)
    );

    public List<Movie> getAllMovies() {
        return movies;
    }
}
