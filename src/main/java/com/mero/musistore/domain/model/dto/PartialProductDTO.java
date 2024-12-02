package com.mero.musistore.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartialProductDTO {
    private Integer productId;
    private Integer quantity;
}
