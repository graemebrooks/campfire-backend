package com.campfire.campfirebackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/api/user/registration")
    public void registerUser(@RequestBody UserDTO user) {
        userService.registerUser(user);
    }

}
