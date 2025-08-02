package com.example.Stock_Manager.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;



    @JoinColumn(name ="buyerId")
    @ManyToOne
    private Buyer buyer;


    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Supplier supplier;


    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name="productName")
    private Product product1;


    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime orderPlaced;
}
