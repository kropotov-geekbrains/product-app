package ru.geekbrains.productapp.rest.mappers;

import org.mapstruct.Mapper;
import ru.geekbrains.api.model.ProductDto;
import ru.geekbrains.productapp.entities.Product;

@Mapper(uses = {DateMapper.class}, componentModel = "spring")
public interface ProductMapper {
    ProductDto productToProductDto(Product product);

    Product productDtoToProduct(ProductDto dto);
}
