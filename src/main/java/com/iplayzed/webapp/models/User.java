package com.iplayzed.webapp.models;

import java.util.UUID;

/***
 * Represents a user with a set user ID and username.
 */
public class User {
    private final UUID userID;
    private String userName;

    /** Sets the userID and userName for a User instance. */
    public User(UUID userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }
}
