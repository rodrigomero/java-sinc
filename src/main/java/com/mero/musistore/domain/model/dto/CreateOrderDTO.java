package com.mero.musistore.domain.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDTO {
    @NotNull
    private Integer userId;
    @NotEmpty(message = "Carrinho vazio")
    private List<PartialProductDTO> cart;
    @NotNull
    private Integer totalQuantity;
}
