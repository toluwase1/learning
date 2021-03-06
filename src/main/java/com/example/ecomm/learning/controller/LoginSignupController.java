package com.example.ecomm.learning.controller;

import com.example.ecomm.learning.model.Admin;
import com.example.ecomm.learning.model.Product;
import com.example.ecomm.learning.model.User;
import com.example.ecomm.learning.service.AdminService;
import com.example.ecomm.learning.service.ProductCategoryService;
import com.example.ecomm.learning.service.ProductService;
import com.example.ecomm.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginSignupController {
    private ProductService productService;
    private ProductCategoryService productCategoryService;
    private AdminService adminService;
    private UserService userService;

    @Autowired
    public LoginSignupController(ProductService productService, ProductCategoryService productCategoryService) {
        this.productService = productService;
        this.productCategoryService = productCategoryService;
       // this.adminService = adminService;
        this.userService = userService;
    }

    @GetMapping("/admin/login")
    public String adminLogin(Model model){
        model.addAttribute("admin", new Admin());
        model.addAttribute("employee", new Admin());
        model.addAttribute("invalid", null);
//        Object adminObject = session.getAttribute("admin");
//        if (adminObject == null) return "redirect:/admin/login";

        //model.addAttribute("login", productService.getAllProducts());
        return "admin-login";
    }


    @PostMapping("/admin/login")
    public String login (HttpSession session, Admin admin, Model model, Product product, User user) {

        Admin onlyAdmin = adminService.getAdminByEmailAndPassword(admin.getEmail(), admin.getPassword());
        System.out.println("post login");
        User onlyUser = userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
        System.out.println("Login working");
        if (onlyAdmin == null && onlyUser == null) {
            model.addAttribute("errorMessage", "Invalid Username/Password.");/** error message for wrong email/password input
             */
            System.out.println("Login working");
            return "admin-login";


        } else if(onlyAdmin != null) {
            session.setAttribute("admin", onlyAdmin);
            return "redirect:/all-products";
        }else{
            model.addAttribute("name", onlyUser.getFirstName());
            session.setAttribute("employee", onlyAdmin);
            return "redirect:/shop-page";
        }
    }
}
