package com.iplayzed.webapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/***
 * Represents a user with a set user ID and username.
 */
public class User implements Comparable<User>{
    private final UUID userID;
    private String userName;

    /**
     * Sets the userID and userName for a User instance.
     */
    public User(@JsonProperty("userID") UUID userID, @JsonProperty("userName") String userName) {
        this.userID = userID;
        this.userName = userName;
    }

    public UUID getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @param comparable the object to be compared.
     */
    @Override
    public int compareTo(User comparable) {
        return this.userID.compareTo(comparable.getUserID());
    }
}
