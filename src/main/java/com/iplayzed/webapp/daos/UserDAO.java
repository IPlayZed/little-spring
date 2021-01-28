package com.iplayzed.webapp.daos;

import com.iplayzed.webapp.models.User;
import java.util.UUID;

/***
 * Interface for defining operations on model User.
 */
public interface UserDAO {
    /***
     * Updates the user's id.
     * @param uuid New id.
     * @param user User to be updated.
     */
    void updateUser(UUID uuid, User user);
    /***
     * Creates a new user with a random ID.
     * @param name the new User's name.
     * @return the new User object.
     */
    default User createUser(String name) {
        return new User(UUID.randomUUID(), name);
    }

}