package com.example.Stock_Manager.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class StockTransaction {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;

    @JoinColumn(name = "buyerId")
    @ManyToOne
    private Buyer buyer;

    @JoinColumn(name="productId")
    @ManyToOne
    private Product product;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime releasedOn;


}
