package ru.geekbrains.koryakin.lesson2;

import org.springframework.stereotype.Component;

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
        products.add(new Product(1L, "Banana", 50));
        products.add(new Product(2L, "Lemon", 100));
        products.add(new Product(3L, "Tomato", 150));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public void addProduct(Long id, String title, int cost) {
        products.add(new Product(id, title, cost));
    }

    public void getProductById(Long id) {
        for (int i = 1; i < products.size(); i++) {
            if (id == i) {
                System.out.println(products.get(i));
            }
        }
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
