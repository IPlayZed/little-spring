package com.iplayzed.webapp.services;

import com.iplayzed.webapp.daos.UserDAO;
import com.iplayzed.webapp.models.User;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User addUser(String name) {
        return userDAO.createUser(name);
    }
}
