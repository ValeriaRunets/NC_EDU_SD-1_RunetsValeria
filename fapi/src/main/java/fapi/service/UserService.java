package fapi.service;


import fapi.models.User;

import java.util.List;

public interface UserService {

    void delete(long id);

    User addUser(User user);

    List<User> getAll();

    User findByLogin(String login);
}
