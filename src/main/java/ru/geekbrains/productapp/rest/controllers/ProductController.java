package ru.geekbrains.productapp.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.productapp.rest.model.ProductDto;
import ru.geekbrains.productapp.services.ProductService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("productId") UUID productId) {
        return new ResponseEntity<>(productService.getById(productId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> saveNewProduct(@RequestBody @Validated ProductDto productDto) {
        return new ResponseEntity<>(productService.saveNewProduct(productDto), HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProductById(@PathVariable("productId") UUID productId,
                                                        @RequestBody @Validated ProductDto productDto) {
        return new ResponseEntity<>(productService.updateProduct(productId, productDto), HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public List<ProductDto> getAll() {
        return productService.getAll();
    }
}
