package backend.service;

import backend.entity.User;
import java.util.*;

public interface UserService {

    void delete(long id);
    User addUser(User user);
    List<User> getAll();
    User findByLogin(String login);
    User getById(long id);
    boolean isExist(String login);
}
