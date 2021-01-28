package com.iplayzed.webapp.api;

import com.iplayzed.webapp.models.User;
import com.iplayzed.webapp.services.DummyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/***
 * Implements HTTP requests using REST API.
 */
@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private final DummyUserService dummyUserService;

    @Autowired
    public UserController(DummyUserService dummyUserService) {
        this.dummyUserService = dummyUserService;
    }

    /***
     * Adds a user to the database. If ID is omitted in the POST request, then it generates a user
     * with the name from POST request and a random ID.
     * The generated user is also written on the standard output.
     * @param user User object to be added.
     */
    @PostMapping
    public void addUser(@RequestBody User user) {
        //TODO: apply unit tests!
        User tmp = dummyUserService.addUser(user);
        System.out.println(tmp + ": " + tmp.getUserID() + " " + tmp.getUserName());
    }

    @GetMapping
    public Set<User> getDB() {
        Set<User> tmp = dummyUserService.getDB();
        for (User user : tmp) {
            System.out.println(user.getUserID() + " " + user.getUserName());
        }
        return tmp;
    }
}
