package com.example.ecomm.learning.repository;

import com.example.ecomm.learning.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository <Admin, Long> {
    Optional<Admin> findAdminByEmail(String email);
    Optional<Admin> findAdminByEmailAndPassword (String email, String password);
}
