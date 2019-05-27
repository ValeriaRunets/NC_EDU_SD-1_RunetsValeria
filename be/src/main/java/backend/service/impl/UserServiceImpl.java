package backend.service.impl;

import backend.entity.User;
import backend.repository.UserRepository;
import backend.service.UserService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    int SIZE_OF_PAGE=5;
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
    public List<User> getAll(int page) {
        return  repository.findAll(PageRequest.of(page, SIZE_OF_PAGE, Sort.by("name"))).getContent();
    }

    @Override
    public User findByLogin(String login) {
        User user=repository.findByLogin(login);
        return user;
    }

    @Override
    public User getById(long id) { return repository.findById(id).get(); }

    @Override
    public boolean isExist(String login) {
        if (repository.findByLogin(login)==null){
            return false;
        }else
            return true;
    }

    @Override
    public int count() {
        return (int)repository.count();
    }
}
