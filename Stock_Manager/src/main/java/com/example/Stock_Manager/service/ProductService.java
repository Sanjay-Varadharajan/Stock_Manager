package com.example.Stock_Manager.service;


import com.example.Stock_Manager.model.Product;
import com.example.Stock_Manager.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    ProductRepo productRepo;

    public List<Product> getallproduct() {
        return productRepo.findAll();
    }

    public String addproduct(Product product) {
        Optional<Product> check = productRepo.findByproductName(product.getProductName());

        if (check.isPresent()) {
            return "Product already Exist..";
        }

        productRepo.save(product);
        return "Product Saved..";
    }

    public String updateproduct(Product product) {
        Optional<Product> check = productRepo.findById(product.getProductId());

        if (check.isEmpty()) {
            return "Product Not Found....";
        }

        Product pro = check.get();

        pro.setProductName(product.getProductName());
        pro.setProductDescription(product.getProductDescription());
        pro.setProductPrice(product.getProductPrice());
        pro.setProductType(product.getProductType());

        productRepo.save(pro);

        return "Product Updated Sucessfully..";
    }

    public String deleteproduct(int productId) {
        Optional<Product> check=productRepo.findById(productId);

        if(check.isEmpty()){
            return "Product Not Available";
        }

        productRepo.deleteById(productId);
        return "Product Deleted Sucessfully..";
    }

    public Optional<Product> getproduct(int productId) {
        return productRepo.findById(productId);
    }
}