package com.mero.musistore.domain.service;

import com.mero.musistore.domain.model.Product;
import com.mero.musistore.domain.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO findProduct(Integer id);
    ProductDTO saveProduct(ProductDTO dto);
    List<ProductDTO> findAll();
}
