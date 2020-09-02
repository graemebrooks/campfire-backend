package com.campfire.campfirebackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // configure spring to use jdbc as the auth mechanism
        auth.jdbcAuthentication().dataSource(jdbcTemplate.getDataSource())
        .usersByUsernameQuery(
                "SELECT email, password, enabled"
                + "FROM user "
                + "WHERE email = ?")
        .authoritiesByUsernameQuery(
                "SELECT email, authority "
                + "FROM authorities "
                + "WHERE email = ?"
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/api/user/registration").and().authorizeRequests()
                .antMatchers("/api/user/registration").permitAll().and().formLogin();
    }

    // TODO: add hashing password encoder
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
