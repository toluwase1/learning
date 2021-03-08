package com.example.ecomm.learning.repository;

import com.example.ecomm.learning.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository <Admin, Long> {
    Optional<Admin> findByEmail(String email);
    Optional<Admin> findByEmailAndPassword (String email, String password);
}
