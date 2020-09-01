package com.campfire.campfirebackend.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class MovieDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Movie> getAllMovies() {
        String sql = "SELECT * FROM movie";
        return jdbcTemplate.query(sql, new movieMapper());
    }

    public Movie getMovie(String id) {
        String sql = "SELECT * FROM movie WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new movieMapper());
    }

    public void addMovie(Movie movie) {
        String sql = "INSERT INTO movie (id, title, year, director) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, UUID.randomUUID().toString(), movie.getTitle(), movie.getYear(),
                movie.getDirector());
    }

    public void updateMovie(String id, Movie movie) {
        String sql = "UPDATE movie SET title = ?, year = ?, director = ? WHERE id = ?";
        jdbcTemplate.update(sql, movie.getTitle(), movie.getYear(), movie.getDirector(), id);
    }

    public void deleteMovie(String id) {
        String sql = "DELETE FROM movie WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


    static class movieMapper implements RowMapper<Movie> {
        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Movie resultMovie = new Movie();
            resultMovie.setId(rs.getString("id"));
            resultMovie.setTitle(rs.getString("title"));
            resultMovie.setYear(rs.getInt("year"));
            resultMovie.setDirector(rs.getString("director"));
            return resultMovie;
        }
    }
}
