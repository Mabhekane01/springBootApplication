package com.assessment.grad001.bheki.ngwenya.restful.controller;
import com.assessment.grad001.bheki.ngwenya.restful.models.Product;
import com.assessment.grad001.bheki.ngwenya.restful.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")

public class productController {

    @Autowired
    public ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getProductsByInvestorEmail(@RequestParam String investorEmail) {
        List<Product> products = service.getProductsByInvestorEmail(investorEmail);
        if (!products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}