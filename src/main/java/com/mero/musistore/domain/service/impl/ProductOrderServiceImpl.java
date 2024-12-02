package com.mero.musistore.domain.service.impl;

import com.mero.musistore.domain.model.Order;
import com.mero.musistore.domain.model.Product;
import com.mero.musistore.domain.model.ProductOrder;
import com.mero.musistore.domain.model.dto.*;
import com.mero.musistore.domain.model.enums.StatusOrderEnum;
import com.mero.musistore.domain.repository.OrdersRepository;
import com.mero.musistore.domain.repository.ProductOrdersRepository;
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
public class ProductOrderServiceImpl implements ProductOrderService {

    private final ProductOrdersRepository repository;
    private final UserService userService;
    private final ProductService productService;

    @Override
    public ProductOrderDTO findProductOrder(Integer id) {
        if (id == null) {
            throw new RuntimeException("Id nulo");
        }
        Optional<ProductOrder> order = repository.findById(id);

        return order.map(ProductOrderDTO::toDTO).orElseThrow(() -> new RuntimeException("ProductOrder nao encontrado"));
    }

    @Override
    public void saveProductOrder(ProductOrderDTO dto) {
        ProductDTO product = productService.findProduct(dto.getProductId());
        Integer quantity = dto.getQuantity();
        BigDecimal partialPrice = product.getPrice().multiply(new BigDecimal(quantity));

        ProductOrder order = new ProductOrder();
        order.setProductId(product.getId());
        order.setQuantity(quantity);
        order.setPartialPrice(partialPrice);
        order.setOrderId(dto.getOrderId());

        repository.save(order);
    }

    @Override
    public ProductOrderDTO updateProductOrder(ProductOrderDTO dto) {
        Optional<ProductOrder> productOrder = repository.findById(dto.getId());
        if(productOrder.isEmpty()) {
            throw new RuntimeException("ProductOrder nao encontrado");
        }
        productOrder.get().cloneFromDTO(dto);
        repository.save(productOrder.get());
        return ProductOrderDTO.toDTO(productOrder.get());
    }

    @Override
    public List<ProductOrderDTO> findAll() {
        repository.findAll().stream().allMatch(productOrder -> productOrder.getId() != null);
        return repository.findAll().stream()
                .map(ProductOrderDTO::toDTO).toList();
    }
}
