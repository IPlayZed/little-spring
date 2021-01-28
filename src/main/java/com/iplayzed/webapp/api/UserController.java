package com.iplayzed.webapp.api;

import com.iplayzed.webapp.services.UserService;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void addUser(String name) {
        userService.addUser(name);
    }
}
