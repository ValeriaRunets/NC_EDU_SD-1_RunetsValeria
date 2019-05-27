package fapi.controller;

import fapi.models.User;
import fapi.security.SecurityJwtConstants;
import fapi.security.TokenProvider;
import fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenProvider tokenProvider;

    @GetMapping(path = "/all", params = { "page"})
    public List<User> getAllUsers(@RequestParam("page") int page) {
        return userService.getAll(page);
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
        user.setFirstEntr(true);
        return userService.addUser(user);
    }

    @RequestMapping(path="/{id}", method= RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") long id) {
        userService.delete(id);
    }
    @GetMapping("/count")
    public int count(){
        return userService.count();
    }
    @RequestMapping(path="/first", method= RequestMethod.GET)
    public boolean isFirst(@RequestHeader("Authorization") String token) {
        String str=tokenProvider.getUsernameFromToken(token.replace(SecurityJwtConstants.TOKEN_PREFIX+" ", ""));
        return getUserByLogin(str).isFirstEntr();
    }

    @RequestMapping(method= RequestMethod.PUT)
    public void changePassword(@RequestBody String password, @RequestHeader("Authorization") String token){
        String str=tokenProvider.getUsernameFromToken(token.replace(SecurityJwtConstants.TOKEN_PREFIX+" ", ""));
        User user=getUserByLogin(str);
        user.setFirstEntr(false);
        user.setPassword(password);
        userService.addUser(user);
    }
}
