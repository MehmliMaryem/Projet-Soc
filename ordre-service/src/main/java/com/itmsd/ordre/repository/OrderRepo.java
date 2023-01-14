package com.itmsd.ordre.repository;

import com.itmsd.ordre.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
