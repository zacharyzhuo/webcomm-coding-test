package com.zachary.demo.Service;

import java.util.ArrayList;
import java.util.List;

import com.zachary.demo.Entity.Product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductService implements CommandLineRunner{

    private List<Product> productList = new ArrayList<>();

    @Override
    public void run(String...args) throws Exception {
        Product p1 = new Product();
        p1.setId(1);
        p1.setName("蘋果");
        p1.setPrice(10);
        productList.add(p1);

        Product p2 = new Product();
        p2.setId(2);
        p2.setName("香蕉");
        p2.setPrice(12);
        productList.add(p2);

        Product p3 = new Product();
        p3.setId(3);
        p3.setName("西瓜");
        p3.setPrice(20);
        productList.add(p3);
    }

    public List<Product> getProductList() {
        return productList;
    }
}
