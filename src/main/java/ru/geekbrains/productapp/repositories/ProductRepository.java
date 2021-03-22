package ru.geekbrains.productapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.productapp.entities.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
