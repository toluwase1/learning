package com.example.ecomm.learning.controller;

import com.example.ecomm.learning.model.Admin;
import com.example.ecomm.learning.model.Product;
import com.example.ecomm.learning.model.User;
import com.example.ecomm.learning.service.AdminService;
import com.example.ecomm.learning.service.ProductCategoryService;
import com.example.ecomm.learning.service.ProductService;
import com.example.ecomm.learning.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class LoginSignupController {
    private ProductService productService;
    private ProductCategoryService productCategoryService;
    private AdminService adminService;
    private UserService userService;

    @Autowired
    public LoginSignupController(ProductService productService, ProductCategoryService productCategoryService, AdminService adminService, UserService userService) {
        this.productService = productService;
        this.productCategoryService = productCategoryService;
        this.adminService = adminService;
        this.userService = userService;
    }

    @GetMapping("/admin/login")
    public String adminLogin(Model model){
        model.addAttribute("admin", new Admin());
        model.addAttribute("user", new User());
        model.addAttribute("invalid", null);
        System.out.println("i got my login page");
        return "admin-login";
    }


    @PostMapping("/admin/login")
    public String login (HttpSession session, Admin admin, Model model, Product product, User user) {
        log.info(admin.getEmail()+admin.getPassword());
        Admin onlyAdmin = adminService.getAdminByEmailAndPassword(admin.getEmail(), admin.getPassword());
//        System.out.println("post login");
        User onlyUser = userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
        System.out.println("Login working");
        if (onlyAdmin == null && onlyUser == null) {
            model.addAttribute("errorMessage", "Invalid Username/Password.");/** error message for wrong email/password input
             */
            System.out.println("Login working");
            return "redirect:/all-products";


        } else if(onlyAdmin != null) {
            session.setAttribute("admin", onlyAdmin);
            System.out.println("Post Login working");
            return "redirect:/all-products";
        }else{
            model.addAttribute("name", onlyUser.getFirstName());
            session.setAttribute("user", onlyUser);
            return "redirect:/shop-page";
        }
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session) {
        if (session != null) {
            session.invalidate();
        }

        model.addAttribute("admin", new Admin());
        model.addAttribute("invalid", null);
        return "redirect:/admin/login";
    }
}
