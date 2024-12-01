package com.mero.musistore.domain.service;

import com.mero.musistore.domain.model.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO findOrder(Integer id);
    Integer saveOrder(OrderDTO dto);

    List<OrderDTO> findAll();
}
