package com.e_com.demo.Controller;

import com.e_com.demo.Model.Product;
import com.e_com.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService service;

    @RequestMapping("/")
    public String greet(){
        return "Hello world";
    }
    @GetMapping("/products")
    public List<Product> getProducts(){
        return service.getAllProducts();
    }
}
