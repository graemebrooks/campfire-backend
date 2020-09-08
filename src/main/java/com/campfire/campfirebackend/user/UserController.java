package com.campfire.campfirebackend.user;

import com.campfire.campfirebackend.security.AuthenticationResponse;
import com.campfire.campfirebackend.security.AuthenticationsRequest;
import com.campfire.campfirebackend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @CrossOrigin()
    @PostMapping("/api/user/registration")
    public void registerUser(@RequestBody UserDTO user) {
        userService.registerUser(user);
    }

    @CrossOrigin
    @PostMapping("/api/user/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationsRequest authenticationsRequest) throws Exception {
        try {
            // attempt authentication using authentication manager
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationsRequest.getUsername(),
                    authenticationsRequest.getPassword()));
        } catch (BadCredentialsException e) {
            // throw exception if credentials are invalid
            throw new Exception("Incorrect email or password", e);
        }

        // if credentials are valid, retrieve all user details for that user
        final Optional<User> user = userService.getUserByEmail(authenticationsRequest.getUsername());
        // generate jwt from user details
        final String jwt = jwtTokenUtil.generateToken(user.get());

        // respond with jwt
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @RequestMapping({"/hello"})
    public String hello() {
        return "Hello World";
    }

//    @CrossOrigin()
//    @PostMapping("/api/user/registration")
//    public void loginUser(@RequestBody UserDTO user) {
//        userService.registerUser(user);
//    }
}
