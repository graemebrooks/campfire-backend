package com.campfire.campfirebackend.user;

import com.campfire.campfirebackend.exceptions.EmailAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(UserDTO userDTO) throws EmailAlreadyExistsException {

        // check if user with email already exists
        if (emailExists(userDTO.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        // encode password
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());

        User user = new User(userDTO.getEmail(), encodedPassword, userDTO.getFirstName(),
                userDTO.getLastName());
        userDao.registerUser(user);
    }

    public Optional<User> getUserByEmail(String email) {
        if (userDao.getUserByEmail(email).size() > 0) {
            return Optional.ofNullable(userDao.getUserByEmail(email).get(0));
        } else {
            return Optional.empty();
        }

    }

    public boolean emailExists(String email) {
        return getUserByEmail(email).isPresent();
    }

}
