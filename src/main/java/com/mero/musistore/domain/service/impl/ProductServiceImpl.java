package com.mero.musistore.domain.service.impl;

import com.mero.musistore.domain.model.Product;
import com.mero.musistore.domain.model.User;
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
        if(id == null) {
            //toDo implementar exception personalizada
            throw new RuntimeException("Id nulo");
        }
        Optional<Product> product = repository.findById(id);

        return product.map(ProductDTO::toDTO).orElseThrow(() -> new RuntimeException("Product nao encontrado"));
    }

    @Override
    public Integer saveProduct(ProductDTO dto) {
        Product entity = dto.toEntity();
        repository.save(entity);

        return entity.getId();
    }

    @Override
    public List<ProductDTO> findAll() {
        repository.findAll().stream().allMatch(product -> product.getId() != null);
        return repository.findAll().stream()
                .map(ProductDTO::toDTO).toList();
    }
}
