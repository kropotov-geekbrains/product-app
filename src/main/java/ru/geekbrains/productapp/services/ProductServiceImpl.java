package ru.geekbrains.productapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import ru.geekbrains.api.model.ProductDto;
import ru.geekbrains.productapp.entities.Product;
import ru.geekbrains.productapp.repositories.ProductRepository;
import ru.geekbrains.productapp.rest.controllers.NotFoundException;
import ru.geekbrains.productapp.rest.mappers.ProductMapper;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto getById(UUID productId) {
        return productMapper.productToProductDto(productRepository.findById(productId)
                .orElseThrow(NotFoundException::new));
    }

    @Override
    public ProductDto saveNewProduct(ProductDto productDto) {
        return productMapper.productToProductDto(productRepository
                .save(productMapper.productDtoToProduct(productDto)));
    }


    @Override
    public ProductDto updateProduct(UUID productId, ProductDto productDto) {
        Product product = productRepository.findById(productId).orElseThrow(NotFoundException::new);

        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setUpc(productDto.getUpc());

        return productMapper.productToProductDto(productRepository.save(product));
    }

    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());
    }

}
