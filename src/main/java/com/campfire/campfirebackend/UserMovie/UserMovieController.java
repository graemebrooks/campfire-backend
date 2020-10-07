package com.campfire.campfirebackend.UserMovie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserMovieController {

    @Autowired
    private UserMovieService userMovieService;

    @CrossOrigin
    @PostMapping("/api/usermovies")
    public void addMovie(@RequestBody UserMovie userMovie) {
        userMovieService.addUserMovie(userMovie);
    }
}
