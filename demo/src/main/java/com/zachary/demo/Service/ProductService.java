package com.zachary.demo.Service;

import com.zachary.demo.Dao.ProductRepository;
import com.zachary.demo.Entity.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductService implements CommandLineRunner{

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String...args) throws Exception {
        // Delete all
        productRepository.deleteAll();

        // Crete products
        productRepository.save(new Product("蘋果", 10, 10));
        productRepository.save(new Product("香蕉", 12, 10));
        productRepository.save(new Product("西瓜", 20, 10));
        
        productRepository.findAll().forEach((product) -> {
            logger.info("{}", product);
        });
    }

}
