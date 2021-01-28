package com.iplayzed.webapp.services;

import com.iplayzed.webapp.daos.UserDAO;
import com.iplayzed.webapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

/***
 * A user service class, specifying DAO implementation.
 * @Service YES
 */
@Service
public class DummyUserService {

    /**
     * Service DAO interface.
     */
    private final UserDAO userDAO;

    /***
     * Injects the the interface implementation, specified in the @Qualifier.
     * @autowired YES
     * @Qualifier Change it for desired DB connectivity implementation.
     * @param userDAO DAO interface implementation, specified in @Qualifier
     */
    @Autowired
    public DummyUserService(@Qualifier("DummyDBAccess") UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User addUser(User user) {
        return userDAO.createUser(user.getUserName());
    }

    public Set<User> getDB() {
        return userDAO.getDB();
    }
}
