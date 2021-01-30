package com.iplayzed.webapp.daos;

import com.iplayzed.webapp.models.User;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

/***
 * This class simulates the implementation for direct DB access, thus acting as
 * a repository.
 * @Repository YES
 */
@Repository("DummyDBAccess")
public class DummyUserDBAccessRepo implements UserDAO {
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

    /***
     * Returns a reference for the DB.
     * @return The users from the DB.
     */
    @Override
    public Set<User> getDB() {
        return dummyDB;
    }

    @Override
    public User getUserByID(UUID uuid) {
        User tmp = null;
        for (User item : dummyDB) {
            if (item.getUserID() == uuid) {
                tmp = item;
                break;
            }
        }
        return tmp;
    }
}
