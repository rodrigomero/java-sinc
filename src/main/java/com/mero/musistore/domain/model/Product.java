package com.mero.musistore.domain.model;

import com.mero.musistore.domain.model.dto.ProductDTO;
import com.mero.musistore.domain.model.enums.CategoryEnum;
import com.mero.musistore.domain.utils.UtilReflection;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String description;

    @Enumerated(EnumType.ORDINAL)
    private CategoryEnum category;

    @Column(precision = 20, scale = 2)
    private BigDecimal price;

    private Integer stock;

    @NotNull
    @Column(name = "is_visible")
    private Boolean isVisible;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductOrder> productOrders;

    public void cloneFromDTO(ProductDTO productDTO) {
        String[] ignoredProperties = UtilReflection.getIgnoredProperties(productDTO);
        BeanUtils.copyProperties(productDTO, this, ignoredProperties);
    }
}
