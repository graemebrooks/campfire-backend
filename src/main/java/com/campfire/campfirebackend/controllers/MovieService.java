package com.campfire.campfirebackend.controllers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

    private List<Movie> movies = new ArrayList<>(Arrays.asList(
            new Movie("movie-1", "Jurassic Park", 1993),
            new Movie("movie-2", "Her", 2013),
            new Movie("movie-3", "Get Out", 2017)
    ));

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovie(String id) {
        return movies.stream().filter(m -> m.getId().equals(id)).findFirst().get();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void updateMovie(String id, Movie movie) {
        for (int i = 0; i < movies.size(); i++) {
            Movie m = movies.get(i);
            if (m.getId().equals(id)) {
                movies.set(i, movie);
                return;
            }
        }
    }
}
