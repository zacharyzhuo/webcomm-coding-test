package com.zachary.demo.Controller;

import java.util.List;
import java.util.Optional;

import com.zachary.demo.Dao.ProductRepository;
import com.zachary.demo.Entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProductApiController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/products")
    public List<Product> readAll() {
        return productRepository.findAll();
    }

    @RequestMapping(value = "/products/{id}")
    public Optional<Product> read(@PathVariable long id) {
        return productRepository.findById(id);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Product product) {
        productRepository.save(product);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable long id, @RequestBody Product newProduct) {
        Product product = productRepository.findById(id).orElse(null);
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        product.setInventory(newProduct.getInventory());
        productRepository.save(product);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        productRepository.deleteById(id);
    }
}
