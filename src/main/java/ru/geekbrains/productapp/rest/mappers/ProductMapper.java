package ru.geekbrains.productapp.rest.mappers;

import org.mapstruct.Mapper;
import ru.geekbrains.productapp.entities.Product;
import ru.geekbrains.productapp.rest.model.ProductDto;

@Mapper(uses = {DateMapper.class}, componentModel = "spring")
public interface ProductMapper {
    ProductDto productToProductDto(Product product);

    Product productDtoToProduct(ProductDto dto);
}
