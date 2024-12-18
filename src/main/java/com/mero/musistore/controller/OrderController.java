package com.mero.musistore.controller;

import com.mero.musistore.domain.model.dto.CreateOrderDTO;
import com.mero.musistore.domain.model.dto.OrderDTO;
import com.mero.musistore.domain.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService service;

    @GetMapping("")
    public List<OrderDTO> getAllOrders() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Integer id) {
        return service.findOrder(id);
    }

    @PostMapping("/save")
    public OrderDTO saveOrder(@RequestBody @Valid CreateOrderDTO dto) {
        return service.saveOrder(dto);
    }

    @PostMapping("/update")
    public OrderDTO updateOrder(@RequestBody @Valid OrderDTO dto) {
        return service.updateOrder(dto);
    }
}
