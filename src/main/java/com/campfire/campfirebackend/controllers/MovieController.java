package com.campfire.campfirebackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/api/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @RequestMapping("/api/movies/{id}")
    public Optional<Movie> getMovie(@PathVariable String id) {
        return movieService.getMovie(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/movies")
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/movies/{id}")
    public void updateMovie(@RequestBody Movie movie, @PathVariable String id) {
        movieService.updateMovie(id, movie);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/movies/{id}")
    public void deleteMovie(@PathVariable String id) {
        movieService.deleteMovie(id);
    }

}
