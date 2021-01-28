package com.iplayzed.webapp.api;

import com.iplayzed.webapp.services.DummyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 */
@RestController
public class UserController {
    private final DummyUserService dummyUserService;

    @Autowired
    public UserController(DummyUserService dummyUserService) {
        this.dummyUserService = dummyUserService;
    }

    public void addUser(String name) {
        dummyUserService.addUser(name);
    }
}
