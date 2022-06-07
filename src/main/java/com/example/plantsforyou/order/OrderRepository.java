package com.example.plantsforyou.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByAppUserIdOrderByCreatedDateDesc(Long id);
}
