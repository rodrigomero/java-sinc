package com.mero.musistore.domain.repository;

import com.mero.musistore.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Order, Integer> {
}
