package com.zachary.demo.Dao;

import com.zachary.demo.Entity.OrderDetail;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    // List<OrderDetail> findByOrder(MyOrder myOrder, Sort sort);

}
