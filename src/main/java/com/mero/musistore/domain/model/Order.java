package com.mero.musistore.domain.model;

import com.mero.musistore.domain.model.dto.OrderDTO;
import com.mero.musistore.domain.model.enums.StatusOrderEnum;
import com.mero.musistore.domain.utils.UtilReflection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    private LocalDateTime date;

    @Enumerated(EnumType.ORDINAL)
    private StatusOrderEnum status;

    @Column(name = "total_quantity")
    private Integer totalQuantity;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<ProductOrder> productOrders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    public void cloneFromDTO(OrderDTO orderDTO) {
        String[] ignoredProperties = UtilReflection.getIgnoredProperties(orderDTO);
        BeanUtils.copyProperties(orderDTO, this,  ignoredProperties);
    }
}
