package ru.geekbrains.koryakin.lesson6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.koryakin.lesson6.entity.Product;
import ru.geekbrains.koryakin.lesson6.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveOrUpdate (Product product) {return productRepository.save(product);}


    public Optional<Product> findById(Long id) {return productRepository.findById(id);}


    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Page<Product> findAll (Specification<Product> spec, Integer page) {
        if (page < 1L) {
            page = 1;
        }
    return productRepository.findAll(spec, PageRequest.of(page-1, 10));}
}
