package com.campfire.campfirebackend.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieDao movieDao;

    public List<Movie> getAllMovies() {
        return movieDao.getAllMovies();
    }

    public Optional<Movie> getMovie(String id) {
        return Optional.ofNullable(movieDao.getMovie(id));
    }

    // test for auth
    public String getMovieTitle(String id) {
        Optional<Movie> movie = getMovie(id);
        String result = movie.isPresent() ? movie.get().getTitle() : "Movie Not Found";
        result += " to see this text you must be logged in!";
        return result;
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
