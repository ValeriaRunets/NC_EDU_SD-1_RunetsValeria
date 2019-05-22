package backend.controller;

import backend.dto.Converter;
import backend.dto.UserDto;
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
    @Autowired
    private Converter converter;

    @RequestMapping(path="/api/user/", method=RequestMethod.POST)
    public UserDto addUser(@RequestBody UserDto user){
        return converter.fromUser(userService.addUser(converter.toUser(user)));
    }

    @RequestMapping(path="/api/user/all", method=RequestMethod.GET)
    public List<UserDto> findAll(){
        List<User> list = userService.getAll();
        List<UserDto> ans=new ArrayList<>();
        for (User user: list){
            ans.add(converter.fromUser(user));
        }
        return  ans;
    }

    @RequestMapping(path="/api/user/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") long id){
        userService.delete(id);
    }

    @RequestMapping(path="api/user/login/{login}", method=RequestMethod.GET)
    public User findByLogin(@PathVariable(name = "login") String login){
        return userService.findByLogin(login);
    }

    @RequestMapping(path="api/user/check/{login}", method=RequestMethod.GET)
    public boolean isExist(@PathVariable(name = "login") String login){
        return userService.isExist(login);
    }

    @RequestMapping(path="api/user/{id}", method= RequestMethod.GET)
    public UserDto getById(@PathVariable(name="id") long id){
        return converter.fromUser(userService.getById(id));
    }
}
