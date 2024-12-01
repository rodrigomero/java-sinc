package com.mero.musistore.domain.model.dto;

import com.mero.musistore.domain.model.Product;
import com.mero.musistore.domain.model.enums.CategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Integer id;
    private String name;
    private String description;
    private CategoryEnum category;
    private BigDecimal price;
    private Integer stock;

    public Product toEntity() {
        Product product = new Product();
        BeanUtils.copyProperties(this, product);
        return product;
    }

    public static ProductDTO toDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        BeanUtils.copyProperties(product, dto);
        return dto;
    }
}
