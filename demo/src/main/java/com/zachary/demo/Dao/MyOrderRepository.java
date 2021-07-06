package com.zachary.demo.Dao;

import com.zachary.demo.Entity.MyOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyOrderRepository extends JpaRepository<MyOrder, Long> {

    

}
