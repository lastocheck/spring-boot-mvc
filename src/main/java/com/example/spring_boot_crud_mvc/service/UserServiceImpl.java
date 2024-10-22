package com.example.spring_boot_crud_mvc.service;

import com.example.spring_boot_crud_mvc.model.User;
import com.example.spring_boot_crud_mvc.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("couldn't find user with id " + id));
        userRepository.delete(user);
    }

    @Override
    public void update(User newUser) {
        userRepository.save(newUser);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
