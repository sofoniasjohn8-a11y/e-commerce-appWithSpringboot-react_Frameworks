package com.e_com.demo.Controller;

import com.e_com.demo.Model.Product;
import com.e_com.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService service;


    @GetMapping("/products")
    public ResponseEntity<List<Product>>getProducts(){
        return new ResponseEntity<>( service.getAllProducts(), HttpStatus.FOUND);
    }
    @GetMapping("/products/{prodid}")
    public ResponseEntity<Product> getProductById(@PathVariable int prodid){

        Product product = service.getProductById(prodid);
        if(product != null)
            return new ResponseEntity<>(product,HttpStatus.FOUND);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}