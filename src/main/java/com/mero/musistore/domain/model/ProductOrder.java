package com.mero.musistore.domain.model;

import com.mero.musistore.domain.model.dto.ProductOrderDTO;
import com.mero.musistore.domain.utils.UtilReflection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_order")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer quantity;

    @Column(name = "partial_price")
    private BigDecimal partialPrice;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    public void cloneFromDTO(ProductOrderDTO productOrderDTO) {
        String[] ignoredProperties = UtilReflection.getIgnoredProperties(productOrderDTO);
        BeanUtils.copyProperties(productOrderDTO, this, ignoredProperties);
    }
}
