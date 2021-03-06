package com.example.ecomm.learning.service.serviceImpl;

import com.example.ecomm.learning.model.Admin;
import com.example.ecomm.learning.model.User;
import com.example.ecomm.learning.repository.AdminRepository;
import com.example.ecomm.learning.repository.UserRepository;
import com.example.ecomm.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private AdminRepository adminRepository;
    private  UserRepository userRepository;

    @Autowired
    public UserServiceImpl(AdminRepository adminRepository, UserRepository userRepository) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
    }


    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        Optional<User> userOptional = userRepository.findUserByEmailAndPassword(email, password);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } return null;
    }
}
