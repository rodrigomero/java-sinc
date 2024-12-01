package com.mero.musistore.controller;

import com.mero.musistore.domain.model.dto.ProductDTO;
import com.mero.musistore.domain.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    @GetMapping("")
    public List<ProductDTO> getAllProducts() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Integer id) {
        return service.findProduct(id);
    }

    @PostMapping("/save")
    public Integer saveProduct(@RequestBody @Valid ProductDTO dto) {

        return service.saveProduct(dto);

    }
}
