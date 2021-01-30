package com.iplayzed.webapp.api;

import com.iplayzed.webapp.models.User;
import com.iplayzed.webapp.services.DummyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

/***
 * Implements HTTP requests using REST API.
 */

//produces: format data into json
@RequestMapping(path = "api/v1/user", produces = "application/json;charset=UTF-8")
@RestController
public class UserController {
    //private final DummyUserService dummyUserService;

    @Autowired
    DummyUserService dummyUserService;
    /*public UserController(DummyUserService dummyUserService) {
        this.dummyUserService = dummyUserService;
    }*/

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

    @GetMapping()
    public Set<User> getDB() {
        Set<User> tmp = dummyUserService.getDB();
        for (User user : tmp) {
            System.out.println(user.getUserID() + " " + user.getUserName());
        }
        return tmp;
    }

    @GetMapping(params = "UUID")
    public User getUserById(@RequestParam UUID uuid) {
        return dummyUserService.getUserByID(uuid);
    }
}
