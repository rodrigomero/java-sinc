package com.mero.musistore.domain.service.impl;

import com.mero.musistore.domain.model.Order;
import com.mero.musistore.domain.model.dto.OrderDTO;
import com.mero.musistore.domain.repository.OrdersRepository;
import com.mero.musistore.domain.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrdersRepository repository;

    @Override
    public OrderDTO findOrder(Integer id) {
        if(id == null) {
            //toDo implementar exception personalizada
            throw new RuntimeException("Id nulo");
        }
        Optional<Order> order = repository.findById(id);

        return order.map(OrderDTO::toDTO).orElseThrow(() -> new RuntimeException("Order nao encontrado"));
    }

    @Override
    public Integer saveOrder(OrderDTO dto) {
        Order entity = dto.toEntity();
        repository.save(entity);

        return entity.getId();
    }

    @Override
    public List<OrderDTO> findAll() {
        repository.findAll().stream().allMatch(order -> order.getId() != null);
        return repository.findAll().stream()
                .map(OrderDTO::toDTO).toList();
    }
}
