package ru.geekbrains.koryakin.lesson6.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.koryakin.lesson6.entity.Product;
import ru.geekbrains.koryakin.lesson6.repository.specifications.ProductSpecification;
import ru.geekbrains.koryakin.lesson6.service.ProductService;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showAll (Model model,
                           @RequestParam (name = "p", defaultValue = "1") Integer pageNumber,
                           @RequestParam (name = "min_price", required = false) Integer minPrice,
                           @RequestParam (name = "max_price", required = false) Integer maxPrice){
        Specification <Product> spec = Specification.where(null);
        if (minPrice != null) {
            spec = spec.and(ProductSpecification.priceGreaterOrEqualsThan(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpecification.priceLesserOrEqualsThan(maxPrice));
        }

        List<Product> productList = productService.findAll(spec, pageNumber).getContent();
        model.addAttribute("products", productList);
        return "all_products";
    }

    @PostMapping("/add")
    public String saveNewProduct(@ModelAttribute Product product) {
        productService.saveOrUpdate(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm (@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit_product_form";
    }

    @PostMapping("/edit")
    public String modifyProduct (@ModelAttribute Product product) {
        productService.saveOrUpdate(product);
        return "redirect:/students/";
    }
}
