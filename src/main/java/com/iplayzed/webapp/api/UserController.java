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
     *
     * @param user adds
     */
    @PostMapping
    public void addUser(@RequestBody User user) {
        dummyUserService.addUser(user);
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
