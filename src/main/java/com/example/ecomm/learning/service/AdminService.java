package com.example.ecomm.learning.service;

import com.example.ecomm.learning.model.Admin;

public interface AdminService {
    Admin getAdminByEmailAndPassword (String email, String password);
}
