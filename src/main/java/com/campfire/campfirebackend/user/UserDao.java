package com.campfire.campfirebackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void registerUser(User user) {
        String sql = "INSERT INTO user (email, password, firstName, lastName, enabled) VALUES (?," +
                " " +
                "?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getEmail(), user.getEncodedPassword(), user.getFirstName(),
                user.getLastName(), 1);
    }

    public List<User> getUserByEmail(String email) {
        String sql = "SELECT * FROM user WHERE email = ?";
        return jdbcTemplate.query(sql, new Object[]{email}, new userMapper());
    }



    static class userMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(rs.getString("email"), rs.getString("password"),
                    rs.getString("firstName"), rs.getString("lastName"), rs.getString("role"));
        }
    }

}
