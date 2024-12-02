package com.mero.musistore.domain.service;

import com.mero.musistore.domain.model.dto.ProductOrderDTO;

import java.util.List;

public interface ProductOrderService {
    ProductOrderDTO findProductOrder(Integer id);

    void saveProductOrder(ProductOrderDTO dto);

    ProductOrderDTO updateProductOrder(ProductOrderDTO dto);

    List<ProductOrderDTO> findAll();
}
