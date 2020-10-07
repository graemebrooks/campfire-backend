package com.campfire.campfirebackend.UserMovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMovieService {

    @Autowired
    private UserMovieDao userMovieDao;

    public void addUserMovie(UserMovie userMovie) {
        userMovieDao.addUserMovie(userMovie);
    }
}
