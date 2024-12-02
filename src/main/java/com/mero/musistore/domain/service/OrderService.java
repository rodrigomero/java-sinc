package com.mero.musistore.domain.service;

import com.mero.musistore.domain.model.dto.CreateOrderDTO;
import com.mero.musistore.domain.model.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO findOrder(Integer id);

    OrderDTO saveOrder(CreateOrderDTO dto);

    OrderDTO updateOrder(OrderDTO dto);

    List<OrderDTO> findAll();
}
