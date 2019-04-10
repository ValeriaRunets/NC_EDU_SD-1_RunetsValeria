package backend.service.impl;

import backend.entity.User;
import backend.repository.UserRepository;
import backend.service.UserService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Override
    public void delete(long id) {
        repository.delete(repository.findById(id).get());
    }

    @Override
    public User addUser(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    public User findByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public User getById(long id) {
        return repository.findById(id).get();
    }
}
