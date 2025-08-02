package com.example.Stock_Manager.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)  //just for updating time and date by java
public class Buyer {


    @Id
    private int buyerId;

    private String buyerName;

    private String buyerAddress;

    private String buyerPhone;

    private String buyerAge;

    private String buyerAccountno;

    private String buyerMail;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime buyeraccountCreatedOn;


    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    private List<Orders> ordersList;


    public Buyer(int buyerId, String buyerName, String buyerAddress, String buyerPhone, String buyerAge,String buyerAccountNo,String buyerMail) {
        this.buyerId = buyerId;
        this.buyerName = buyerName;
        this.buyerAddress = buyerAddress;
        this.buyerPhone = buyerPhone;
        this.buyerAge = buyerAge;
        this.buyerAccountno=buyerAccountNo;
        this.buyerMail=buyerMail;
    }


    public Buyer() {

    }


    public Buyer(String buyerName, String buyerAddress, String buyerPhone, String buyerAge,String buyerAccountNo,String buyerMail) {
        this.buyerName = buyerName;
        this.buyerAddress = buyerAddress;
        this.buyerPhone = buyerPhone;
        this.buyerAge = buyerAge;
        this.buyerAccountno=buyerAccountNo;
        this.buyerMail=buyerMail;
    }

}
