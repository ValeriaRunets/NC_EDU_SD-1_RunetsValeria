package backend.controller;

import backend.entity.User;
import backend.repository.UserRepository;
import backend.service.UserService;
import backend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(path="/addUser", method = RequestMethod.POST)
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @RequestMapping(path="/allUsers", method=RequestMethod.GET)
    public List<User> findAll(){
        return userService.getAll();
    }

    @RequestMapping(path="/deleteUser", method=RequestMethod.GET)
    public void delete(@RequestParam long id){
        userService.delete(id);
    }

    @RequestMapping(path="/userByLogin", method=RequestMethod.GET)
    public User findByLogin(@RequestParam String login){
        return userService.findByLogin(login);
    }
}
