package ru.geekbrains.koryakin.lesson2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import ru.geekbrains.koryakin.lesson2.model.Product;
import ru.geekbrains.koryakin.lesson2.services.ProductService;

import java.util.List;


@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showAllProducts (Model model){
        List <Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
       return "all_products";
   }




}
