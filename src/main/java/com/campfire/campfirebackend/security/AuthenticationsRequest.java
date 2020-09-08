package com.campfire.campfirebackend.security;

public class AuthenticationsRequest {

    private String username;
    private String password;

    public AuthenticationsRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // no arg constructor
    public AuthenticationsRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
