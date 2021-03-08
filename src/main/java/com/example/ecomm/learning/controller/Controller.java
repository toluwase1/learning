package com.example.ecomm.learning.controller;

import com.example.ecomm.learning.model.Admin;
import com.example.ecomm.learning.model.Product;
import com.example.ecomm.learning.model.ProductCategory;
import com.example.ecomm.learning.repository.ProductCategoryRepository;
import com.example.ecomm.learning.repository.ProductRepository;
import com.example.ecomm.learning.service.ProductCategoryService;
import com.example.ecomm.learning.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@org.springframework.stereotype.Controller
public class Controller {
    private ProductService productService;
    private ProductCategoryService productCategoryService;

    @Autowired
    public Controller(ProductService productService) {
        this.productService = productService;
        this.productCategoryService = productCategoryService;
    }



    @GetMapping("/all-products")
    public String allProduct(Model model, HttpSession session) {
        Object adminObject = session.getAttribute("admin");
        if (adminObject == null) return "redirect:/admin/login";

        model.addAttribute("allProducts", productService.getAllProducts());
        return "all-products";
    }

    @GetMapping("/product-page/{id}")
    public String product(@PathVariable Long id, Model model, HttpSession session) throws Exception {
        Object adminObject = session.getAttribute("admin");
        if (adminObject == null) return "redirect:/admin/login";
        Product product = productService.getProductById(id);
//        System.out.println(product.getName());
//        System.out.println(product.getImage());
        model.addAttribute("oneProduct", productService.getProductById(id));
        //model.addAttribute("product-category", productService.findAll());
        return "product-page";
    }

    @GetMapping("/new-product")
    public String newProduct(Model model, HttpSession session) {
        Object adminObject = session.getAttribute("admin");
        if (adminObject == null) return "redirect:/admin/login";

        //create model attribute to bind form data
        Product product = new Product();
        model.addAttribute("product", product);
        return "new-product";
    }

    @PostMapping("/save-product")
    public String saveProductMethod(@ModelAttribute("product") Product product, HttpSession session) {

        productService.addProduct(product);
        return "redirect:/all-products";
    }


    @GetMapping("/update-product/{id}")
    public String updateProduct(@PathVariable(value = "id") long id, Model model, HttpSession session) throws Exception {
        Object adminObject = session.getAttribute("admin");
        if (adminObject == null) return "redirect:/admin/login";
//        //set product as a model attribute to pre-populate the form
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "update-product";
    }

    @PostMapping("/update-product/{id}")
    public String updateProduct(@ModelAttribute("product") Product product, @PathVariable(value = "id") long id, HttpSession session) {
        Object adminObject = session.getAttribute("admin");
        if (adminObject == null) return "redirect:/admin/login";

        //save product to database
        productService.updateProduct(product, id);
        return "redirect:/all-products";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteMethod(@PathVariable(value = "id") long id, Model model, HttpSession session) {
        Object adminObject = session.getAttribute("admin");
        if (adminObject == null) return "redirect:/admin/login";
        // call delete employee method
        this.productService.deleteProductById(id);
        System.out.println("I GOT DELE");
        return "redirect:/all-products";
    }

    @GetMapping("/shop-page")
    public String shopPage(Model model, HttpSession session) {
//        Object userObject = session.getAttribute("user");
//        if (userObject == null) return "";
        model.addAttribute("allProducts", productService.getAllProducts());
        return "shop-page";
    }


    @PostMapping("/add-category")
    public String addCategory(Model model, HttpSession session, Admin admin, Long id) {
        Object userObject = session.getAttribute("admin");
        if (userObject == null) return "redirect:/admin/login";
        ProductCategory productCategory = new ProductCategory();




//        Skill skill = skillRepository.findOne(skillId);
//        Developer developer = repository.findOne(id);
//
//        if (developer != null) {
//            if (!developer.hasSkill(skill)) {
//                developer.getSkills().add(skill);
//            }
//            repository.save(developer);
//            model.addAttribute("developer", repository.findOne(id));
//            model.addAttribute("skills", skillRepository.findAll());
//            return "redirect:/developer/" + developer.getId();
//        }
//
//        model.addAttribute("developers", repository.findAll());
//        return "redirect:/developers";
//


        model.addAttribute("allProducts", productService.getAllProducts());
        return "redirect:/all-products";
    }





    //
//    @RequestMapping(value="/developers",method=RequestMethod.GET)
//    public String developersList(Model model) {
//        model.addAttribute("developers", repository.findAll());
//        return "developers";
//    }
//
//    @RequestMapping(value="/developers",method=RequestMethod.POST)
//    public String developersAdd(@RequestParam String email,
//                                @RequestParam String firstName, @RequestParam String lastName, Model model) {
//        Developer newDeveloper = new Developer();
//        newDeveloper.setEmail(email);
//        newDeveloper.setFirstName(firstName);
//        newDeveloper.setLastName(lastName);
//        repository.save(newDeveloper);
//
//        model.addAttribute("developer", newDeveloper);
//        model.addAttribute("skills", skillRepository.findAll());
//        return "redirect:/developer/" + newDeveloper.getId();
//    }
//
//    @RequestMapping(value="/developer/{id}/skills", method=RequestMethod.POST)
//    public String developersAddSkill(@PathVariable Long id, @RequestParam Long skillId, Model model) {
//        Skill skill = skillRepository.findOne(skillId);
//        Developer developer = repository.findOne(id);
//
//        if (developer != null) {
//            if (!developer.hasSkill(skill)) {
//                developer.getSkills().add(skill);
//            }
//            repository.save(developer);
//            model.addAttribute("developer", repository.findOne(id));
//            model.addAttribute("skills", skillRepository.findAll());
//            return "redirect:/developer/" + developer.getId();
//        }
//
//        model.addAttribute("developers", repository.findAll());
//        return "redirect:/developers";
//    }

}

