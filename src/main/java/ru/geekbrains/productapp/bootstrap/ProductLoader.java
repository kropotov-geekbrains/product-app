package ru.geekbrains.productapp.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.geekbrains.productapp.entities.Product;
import ru.geekbrains.productapp.repositories.ProductRepository;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class ProductLoader implements CommandLineRunner {

    public static final String PRODUCT_1_UPC = "0631234200036";
    public static final String PRODUCT_2_UPC = "0631234300019";
    public static final String PRODUCT_3_UPC = "0083783375213";

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if(productRepository.count() == 0 ) {
            loadProductObjects();
        }
    }

    private void loadProductObjects() {
        Product product1 = Product.builder()
                .title("Milk")
                .price(new BigDecimal("79.90"))
                .upc(PRODUCT_1_UPC)
                .build();
        Product product2 = Product.builder()
                .title("Bread")
                .price(new BigDecimal("40.00"))
                .upc(PRODUCT_2_UPC)
                .build();
        Product product3 = Product.builder()
                .title("cola")
                .price(new BigDecimal("59.90"))
                .upc(PRODUCT_3_UPC)
                .build();

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
    }
}
