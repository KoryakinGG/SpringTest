package ru.geekbrains.koryakin.Lesson2.repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.koryakin.Lesson2.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init () {
        this.products = new ArrayList<>();
        this.products.add(new Product(1L, "Banana", 50));
        this.products.add(new Product(2L, "Lemon", 100));
        this.products.add(new Product(3L, "Tomato", 150));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    public Product findById(Long id ) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                System.out.println(p);
                return  p;
            }
        }
        throw new RuntimeException("You are Full");
    }
}
