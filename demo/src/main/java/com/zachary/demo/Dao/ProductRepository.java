package com.zachary.demo.Dao;

import com.zachary.demo.Entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Member findByIdStartsWith(String id);

}