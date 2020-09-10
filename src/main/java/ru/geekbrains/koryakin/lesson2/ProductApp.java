package ru.geekbrains.koryakin.lesson2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProductAppConfig.class);

        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);

        productRepository.getAllProducts();

        context.close();
    }
}
