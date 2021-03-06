package com.example.ecomm.learning.repository;

import com.example.ecomm.learning.model.Admin;
import com.example.ecomm.learning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByEmailAndPassword (String email, String password);
}
