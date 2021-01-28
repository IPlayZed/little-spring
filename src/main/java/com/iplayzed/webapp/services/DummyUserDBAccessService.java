package com.iplayzed.webapp.services;

import com.iplayzed.webapp.daos.UserDAO;
import com.iplayzed.webapp.models.User;

import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

public class DummyUserDBAccessService implements UserDAO {
    private static final Set<User> dummyDB = new TreeSet<>();

    /***
     * Updates the user's id.
     * @param name The name to be changed to.
     * @param user User to be updated.
     */
    @Override
    public void updateUser(String name, User user) {
        for (User iterable : dummyDB) {
            if (iterable.getUserID() == user.getUserID()) {
                iterable.setUserName(name);
            }
        }
    }

    /***
     * Inserts a user into the database.
     * @param user User object to be inserted.
     */
    @Override
    public void insertUser(User user) {
        dummyDB.add(user);
    }

    /***
     * Creates a new user with a random ID and a given name.
     * @param uuid the new user's id.
     * @param name the new user's name.
     * @return the new User object.
     */

    @Override
    public User createUser(UUID uuid, String name) {
        return new User(uuid, name);
    }
}
