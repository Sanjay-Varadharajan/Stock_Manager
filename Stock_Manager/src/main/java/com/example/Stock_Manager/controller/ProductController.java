package com.example.Stock_Manager.controller;

import com.example.Stock_Manager.model.Product;
import com.example.Stock_Manager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stocker")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getallproduct(){
        return productService.getallproduct();
    }

    @PostMapping("/addproduct")
    public String addproduct(@RequestBody Product product){
        return productService.addproduct(product);
    }

    @PutMapping("/updateproduct")
    public String updatedproduct(@RequestBody Product product){
        return productService.updateproduct(product);
    }

    @DeleteMapping("/deleteproduct")
    public String deleteproduct(@RequestParam("productId")int productId){
        return productService.deleteproduct(productId);
    }


    @GetMapping("/product/{productId}")
    public Optional<Product> getproduct(@PathVariable("productId")int productId){
        return productService.getproduct(productId);
    }

}
