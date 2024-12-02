package com.mero.musistore.domain.repository;

import com.mero.musistore.domain.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrdersRepository extends JpaRepository<ProductOrder, Integer> {
}
