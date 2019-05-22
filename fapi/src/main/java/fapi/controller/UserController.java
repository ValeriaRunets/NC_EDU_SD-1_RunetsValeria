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

    @GetMapping("/check/{login}")
    public boolean isExist(@PathVariable(name = "login") String login) {
        return userService.isExist(login);
    }

    @RequestMapping(path="/{id}", method= RequestMethod.GET)
    public User getById(@PathVariable(name="id") long id){
        return userService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public User saveUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(path="/{id}", method= RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") long id) {
        userService.delete(id);
    }
}
