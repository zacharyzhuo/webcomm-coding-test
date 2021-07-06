package com.zachary.demo.Controller;

import com.zachary.demo.Dao.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String ShowProduct(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }

}
