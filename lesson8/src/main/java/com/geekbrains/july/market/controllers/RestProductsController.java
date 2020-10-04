package com.geekbrains.july.market.controllers;


import com.geekbrains.july.market.entities.Product;
import com.geekbrains.july.market.exceptions.ProductNotFoundException;
import com.geekbrains.july.market.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/products")
public class RestProductsController {

    private ProductsService productsService;

    @Autowired
    public RestProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
//    @ResponseBody
    public List <Product> getAllProducts () {
        return productsService.findAll();
    }

    @GetMapping ("/{id}")
//    @ResponseBody
    public Product getOneProducts (@PathVariable Long id) {
        return productsService.findById(id);
    }

    @DeleteMapping
//    @ResponseBody
    public String deleteAllProducts (@PathVariable Long id) {
        productsService.deleteAll();
        return "all product deleted";
    }

    @DeleteMapping ("/{id}")
//    @ResponseBody
    public String deleteOneProducts (@PathVariable Long id) {
        productsService.deleteById(id);
        return "product deleted";
    }

    @PostMapping
//    @ResponseBody
    public Product saveNewProduct (@RequestBody Product product) {
        if (product.getId() != null) {
            product.setId(null);
        }
        return productsService.saveProduct(product);
    }

    @PutMapping
    public Product modifyProduct (@RequestBody Product product) {
        if (product.getId() == null || !productsService.existsById(product.getId())) {
         throw new ProductNotFoundException("Product not found, id: " + product.getId());
        }
        
        return productsService.saveOrUpdate(product);
    }
}
