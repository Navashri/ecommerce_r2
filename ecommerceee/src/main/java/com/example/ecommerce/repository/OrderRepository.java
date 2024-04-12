package com.example.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.ecommerce.model.Orders;


public interface OrderRepository extends JpaRepository<Orders, Long> {
    
    List<Orders> findOrdersByUserId(Long userId);
 
    @Query("SELECT o FROM Orders o WHERE o.userId = :userId")
    List<Orders> findOrdersByUserIdUsingQuery(Long userId);
    
    default Orders saveOrder(Orders order) {
        return save(order);
    }

    default List<Orders> getAllOrders() {
        return findAll();
    }

    default Orders getOrderById(Long id) {
        return findById(id).orElse(null);
    }

    default void deleteOrder(Long id) {
        deleteById(id);
    }

}
