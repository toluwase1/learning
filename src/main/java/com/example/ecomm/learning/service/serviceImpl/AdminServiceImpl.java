package com.example.ecomm.learning.service.serviceImpl;

import com.example.ecomm.learning.model.Admin;
import com.example.ecomm.learning.repository.AdminRepository;
import com.example.ecomm.learning.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {
    private AdminRepository adminRepository;
    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @Override
    public Admin getAdminByEmailAndPassword(String email, String password) {
        log.info("line 23");
        System.out.println("i am here 24");
        Optional<Admin> adminOptional = adminRepository.findByEmailAndPassword(email, password);
//        log.info(adminOptional.get().toString());
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
