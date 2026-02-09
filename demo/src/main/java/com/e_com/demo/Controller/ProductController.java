package com.e_com.demo.Controller;

import com.e_com.demo.Model.Product;
import com.e_com.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService service;


    @GetMapping("/products")
    public ResponseEntity<List<Product>>getProducts(){
        return new ResponseEntity<>( service.getAllProducts(), HttpStatus.OK);
    }
    @GetMapping("/products/{prodid}")
    public ResponseEntity<Product> getProductById(@PathVariable int prodid){

        Product product = service.getProductById(prodid);
        if(product != null)
            return new ResponseEntity<>(product,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/products")
    public ResponseEntity<?> addProduct(
            @RequestPart("product") Product product,
            @RequestPart("imageFile") MultipartFile imageFile) {
        System.out.println("hello");
        try {
            System.out.println("Received Product: " + product); // Check if this even prints
            Product product1 = service.addProduct(product, imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace(); // THIS WILL PRINT THE EXACT ERROR IN YOUR IDE CONSOLE (IntelliJ/Eclipse)
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}