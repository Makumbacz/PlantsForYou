package com.example.plantsforyou.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByAppUserIdOrderByCreatedDateDesc(Long id);
    Order findOrderById(Long id);
}
