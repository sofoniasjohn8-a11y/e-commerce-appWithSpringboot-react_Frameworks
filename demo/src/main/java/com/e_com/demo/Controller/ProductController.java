package com.e_com.demo.Controller;

import com.e_com.demo.Model.Product;
import com.e_com.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService service;


    @GetMapping("/products")
    public List<Product> getProducts(){
        return service.getAllProducts();
    }
    @GetMapping("/products/{prodid}")
    public Product getProductById(@PathVariable int prodid){
        return service.getProductById(prodid);
    }
}
