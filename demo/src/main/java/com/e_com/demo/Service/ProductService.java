package com.e_com.demo.Service;

import com.e_com.demo.Model.Product;
import com.e_com.demo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int prodid) {
        return repo.findById(prodid).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imagefile) throws IOException {
        product.setImageName(imagefile.getName());
        product.setImageType(imagefile.getContentType());
        product.setImageDate(imagefile.getBytes());
        return repo.save(product);
    }
}
