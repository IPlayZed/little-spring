package com.iplayzed.webapp.daos;

import com.iplayzed.webapp.models.User;
import java.util.UUID;

/***
 * Interface for defining operations on model User.
 */
public interface UserDAO {
    /***
     * Creates a new user with a random ID.
     * @param name the new User's name.
     * @return the new User object.
     */
    default User createUser(String name) {
        return new User(UUID.randomUUID(), name);
    }
    /***
     * Inserts a user into the database.
     * @param user User object to be inserted.
     */
    void insertUser(User user);
    /***
     * Updates the user's id.
     * @param name The name to be changed to.
     * @param user User to be updated.
     */
    void updateUser(String name, User user);
}
