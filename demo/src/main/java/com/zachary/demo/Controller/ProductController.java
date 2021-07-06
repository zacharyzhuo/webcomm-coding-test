package com.zachary.demo.Controller;

import com.zachary.demo.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String ShowProduct(Model model) {
        System.out.print(productService.getProductList());
        model.addAttribute("products", productService.getProductList());
        return "index";
    }

}