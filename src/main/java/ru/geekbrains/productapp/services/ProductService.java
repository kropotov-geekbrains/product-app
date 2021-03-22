package ru.geekbrains.productapp.services;



import ru.geekbrains.api.model.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductDto getById(UUID productId);

    ProductDto saveNewProduct(ProductDto productDto);

    ProductDto updateProduct(UUID productId, ProductDto productDto);

    List<ProductDto> getAll();
}
