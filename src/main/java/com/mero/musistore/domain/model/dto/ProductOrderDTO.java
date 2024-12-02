package com.mero.musistore.domain.model.dto;

import com.mero.musistore.domain.model.Order;
import com.mero.musistore.domain.model.ProductOrder;
import com.mero.musistore.domain.model.enums.StatusOrderEnum;
import jakarta.validation.constraints.NotNull;
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
public class ProductOrderDTO {

    private Integer id;
    @NotNull
    private Integer quantity;
    private BigDecimal partialPrice;
    @NotNull
    private Integer productId;
    @NotNull
    private Integer orderId;

    public ProductOrder toEntity() {
        ProductOrder productOrder = new ProductOrder();
        BeanUtils.copyProperties(this, productOrder);
        return productOrder;
    }

    public static ProductOrderDTO toDTO(ProductOrder productOrder) {
        ProductOrderDTO dto = new ProductOrderDTO();
        BeanUtils.copyProperties(productOrder, dto);
        return dto;
    }
}
