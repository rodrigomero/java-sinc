package com.mero.musistore.domain.service.impl;

import com.mero.musistore.domain.model.Order;
import com.mero.musistore.domain.model.dto.*;
import com.mero.musistore.domain.model.enums.StatusOrderEnum;
import com.mero.musistore.domain.repository.OrdersRepository;
import com.mero.musistore.domain.service.OrderService;
import com.mero.musistore.domain.service.ProductOrderService;
import com.mero.musistore.domain.service.ProductService;
import com.mero.musistore.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrdersRepository repository;
    private final UserService userService;
    private final ProductService productService;
    private final ProductOrderService productOrderService;

    @Override
    public OrderDTO findOrder(Integer id) {
        if (id == null) {
            //toDo implementar exception personalizada
            throw new RuntimeException("Id nulo");
        }
        Optional<Order> order = repository.findById(id);

        return order.map(OrderDTO::toDTO).orElseThrow(() -> new RuntimeException("Order nao encontrado"));
    }

    @Override
    public OrderDTO saveOrder(CreateOrderDTO dto) {
        Integer userId = userService.findUser(dto.getUserId()).getId();
        LocalDateTime now = LocalDateTime.now();
        Integer totalQuantity = dto.getTotalQuantity();
        BigDecimal totalPrice = dto.getCart().stream()
                .map(partialProduct -> {
                    ProductDTO product = productService.findProduct(partialProduct.getProductId());
                    return product.getPrice().multiply(BigDecimal.valueOf(partialProduct.getQuantity()));
                }).reduce(BigDecimal.ZERO, BigDecimal::add);

        Order order = new Order();
        order.setUserId(userId);
        order.setDate(now);
        order.setStatus(StatusOrderEnum.CONFIRMADO);
        order.setTotalQuantity(totalQuantity);
        order.setTotalPrice(totalPrice);

        repository.save(order);

        OrderDTO orderDTO = OrderDTO.toDTO(order);
        for (PartialProductDTO pp : dto.getCart()) {
            ProductOrderDTO productOrderDTO = new ProductOrderDTO();
            productOrderDTO.setProductId(pp.getProductId());
            productOrderDTO.setQuantity(pp.getQuantity());
            productOrderDTO.setOrderId(orderDTO.getId());

            productOrderService.saveProductOrder(productOrderDTO);
        }

        return orderDTO;
    }

    @Override
    public OrderDTO updateOrder(OrderDTO dto) {
        Optional<Order> order = repository.findById(dto.getId());
        if (order.isEmpty()) {
            throw new RuntimeException("Order nao encontrado");
        }
        order.get().cloneFromDTO(dto);
        repository.save(order.get());
        return OrderDTO.toDTO(order.get());
    }

    @Override
    public List<OrderDTO> findAll() {
        repository.findAll().stream().allMatch(order -> order.getId() != null);
        return repository.findAll().stream()
                .map(OrderDTO::toDTO).toList();
    }
}
