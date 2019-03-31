package backend.service;

import backend.entity.User;
import com.sun.tools.javac.util.List;

public interface UserService {

    void delete(long id);
    User addUser(User user);
    List<User> getAll();
    User findByLogin(String login);
    User getById(long id);
}
