package com.iplayzed.webapp.api;

import com.iplayzed.webapp.models.User;
import com.iplayzed.webapp.services.DummyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
