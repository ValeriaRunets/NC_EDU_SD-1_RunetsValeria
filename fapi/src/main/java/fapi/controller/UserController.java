package fapi.controller;

import fapi.models.User;
import fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/login/{login}")
    public User getUserByLogin(@PathVariable(name = "login") String login) {
        return userService.findByLogin(login);
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST, produces = "application/json")
    public User saveUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        userService.delete(id);
    }
}
