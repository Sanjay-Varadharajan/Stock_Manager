package com.example.Stock_Manager.model;

//varible should in camelCase

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private String productType;
    private String productDescription;
    private  int productPrice;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime productArriveddate;

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    private List<Stockproduct> stockproductList;


    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<Orders> orders;


    public Product(int productId, String productName, String productType, String productDescription,int productPrice) {

        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.productDescription = productDescription;
        this.productPrice=productPrice;

    }

    public Product() {

    }

    public Product(String productName, String productType, String productDescription,int productPrice) {
        this.productName = productName;
        this.productType = productType;
        this.productDescription = productDescription;
        this.productPrice=productPrice;

    }



}
