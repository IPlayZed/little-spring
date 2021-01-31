package com.iplayzed.webapp.api;

import com.iplayzed.webapp.models.User;
import com.iplayzed.webapp.services.DummyUserService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

/***
 * Implements HTTP requests using REST API.
 */

//produces: format data into json
//see more for https://docs.spring.io/spring-framework/docs/5.3.3/reference/html/web.html#mvc
@RequestMapping(path = "api/v1/user", produces = "application/json;charset=UTF-8")
@RestController
public class UserController {
    private final DummyUserService dummyUserService;

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

    //Using @GetMapping is the same as using @RequestMapping(method=RequestMethod.GET)
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
