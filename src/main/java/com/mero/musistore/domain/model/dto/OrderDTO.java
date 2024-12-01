package com.mero.musistore.domain.model.dto;

import com.mero.musistore.domain.model.Order;
import com.mero.musistore.domain.model.enums.StatusOrderEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Integer id;
    private Integer userId;
    private LocalDateTime date;
    private StatusOrderEnum status;
    private Integer totalQuantity;
    private BigDecimal totalPrice;

    public Order toEntity() {
        Order order = new Order();
        BeanUtils.copyProperties(this, order);
        return order;
    }

    public static OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        BeanUtils.copyProperties(order, dto);
        return dto;
    }
}
