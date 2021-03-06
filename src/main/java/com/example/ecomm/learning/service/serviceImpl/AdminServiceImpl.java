package com.example.ecomm.learning.service.serviceImpl;

import com.example.ecomm.learning.model.Admin;
import com.example.ecomm.learning.repository.AdminRepository;
import com.example.ecomm.learning.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AdminServiceImpl implements AdminService {
    private AdminRepository adminRepository;
    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @Override
    public Admin getAdminByEmailAndPassword(String email, String password) {
        Optional<Admin> adminOptional = adminRepository.findAdminByEmailAndPassword(email, password);
        if (adminOptional.isPresent()) {
            return adminOptional.get();
        } return null;
    }

//    @Override
//    public Admin getAdminByEmail(String email, String password) {
//        Optional<Admin> adminOptional = adminRepository.findAdminByEmail(email);
//        if (adminOptional.isPresent()) {
//            return adminOptional.get();
//        } return null;
//    }



}
