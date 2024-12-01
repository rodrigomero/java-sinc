package com.mero.musistore.domain.service;

import com.mero.musistore.domain.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO findProduct(Integer id);
    Integer saveProduct(ProductDTO dto);

    List<ProductDTO> findAll();
}
