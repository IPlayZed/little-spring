package com.iplayzed.webapp.daos;

import com.iplayzed.webapp.models.User;

import java.util.Set;
import java.util.TreeSet;

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
}
