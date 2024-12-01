package com.mero.musistore.domain.repository;

import com.mero.musistore.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Integer> {
}
