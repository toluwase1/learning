package com.example.ecomm.learning.service;

import com.example.ecomm.learning.model.User;

public interface UserService {
    User getUserByEmailAndPassword (String email, String password);
}
