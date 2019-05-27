package fapi.service;


import fapi.models.User;

import java.util.List;

public interface UserService {

    void delete(long id);

    User addUser(User user);

    List<User> getAll(int page);

    User findByLogin(String login);

    boolean isExist (String login);

    User getById(long id);

    int count();
}
