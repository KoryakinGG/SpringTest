package ru.geekbrains.koryakin.Lesson2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.koryakin.Lesson2.model.Product;
import ru.geekbrains.koryakin.Lesson2.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List <Product> getAllProduct (){
        System.out.println("return all products");
        return productRepository.getAllProducts();
    }

    public Product addNewProduct (Product product){
        System.out.println("Product added");
        return productRepository.addProduct(product);
    }

    public Product findProduct (Long id) {
        System.out.println("products find by id: " + id);
        return productRepository.findById(id);
    }
}
