package com.mero.musistore.domain.service.impl;

import com.mero.musistore.domain.model.Product;
import com.mero.musistore.domain.model.dto.ProductDTO;
import com.mero.musistore.domain.repository.ProductsRepository;
import com.mero.musistore.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductsRepository repository;

    @Override
    public ProductDTO findProduct(Integer id) {
        if (id == null) {
            //toDo implementar exception personalizada
            throw new RuntimeException("Id nulo");
        }
        Optional<Product> product = repository.findById(id);

        return product.map(ProductDTO::toDTO).orElseThrow(() -> new RuntimeException("Product nao encontrado"));
    }

    @Override
    public ProductDTO saveProduct(ProductDTO dto) {
        if (dto.getId() != null) {
            return updateProduct(dto);
        }
        dto.setIsVisible(true);
        Product entity = dto.toEntity();
        repository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    private ProductDTO updateProduct(ProductDTO dto) {
        Optional<Product> product = repository.findById(dto.getId());
        if (product.isEmpty()) {
            throw new RuntimeException("Product nao encontrado");
        }
        product.get().cloneFromDTO(dto);
        repository.save(product.get());
        return ProductDTO.toDTO(product.get());
    }

    @Override
    public List<ProductDTO> findAll() {
        return repository.findAll().stream()
                .map(ProductDTO::toDTO).toList();
    }
}
