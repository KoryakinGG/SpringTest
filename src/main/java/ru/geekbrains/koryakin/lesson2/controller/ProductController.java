package ru.geekbrains.koryakin.lesson2.controller;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import java.util.UUID;

@Controller
public class ProductController {

    public ProductController() {
        System.out.println("ProductController constructor start");
    }

    @RequestMapping("/")
    public String index (Model model){
        model.addAttribute("message", "Me message plus random UUID -> " + UUID.randomUUID());
    return "index";
    }


}
