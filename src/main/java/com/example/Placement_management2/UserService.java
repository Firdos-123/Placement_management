package com.example.Placement_management2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User get(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NoSuchElementException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
