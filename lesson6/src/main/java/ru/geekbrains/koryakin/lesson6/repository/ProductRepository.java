package ru.geekbrains.koryakin.lesson6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.geekbrains.koryakin.lesson6.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor <Product> {

}
