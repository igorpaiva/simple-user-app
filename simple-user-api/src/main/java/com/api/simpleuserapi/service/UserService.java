package com.api.simpleuserapi.service;

import com.api.simpleuserapi.model.User;
import org.springframework.stereotype.Service;
import com.api.simpleuserapi.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User update(Long id, User user) {
        User userToUpdate = userRepository.findById(id).orElse(null);
        if(userToUpdate != null) {
            userToUpdate.setName(user.getName());
            userToUpdate.setAge(user.getAge());
            userToUpdate.setHeight(user.getHeight());
            return userRepository.save(userToUpdate);
        }
        return null;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
