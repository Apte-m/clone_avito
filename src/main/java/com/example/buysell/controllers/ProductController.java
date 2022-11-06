package com.example.buysell.controllers;

import com.example.buysell.Service.ProductService;
import com.example.buysell.models.Product;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", productService.list(title));
        return "products";
    }

    @SneakyThrows
    @PostMapping("/product/create")
    public String createProduct(@RequestParam("file1") MultipartFile file1
            , @RequestParam("file2") MultipartFile file2
            , @RequestParam("file3") MultipartFile file3, Product product) {
        productService.saveProduct(product, file1, file2, file3);
        return "redirect:/";

    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.productDelete(id);
        return "redirect:/";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImages());
        return "product-info";
    }
}
