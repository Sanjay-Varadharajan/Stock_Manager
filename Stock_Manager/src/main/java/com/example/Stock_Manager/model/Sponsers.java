package com.example.Stock_Manager.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Sponsers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sponserId;

    private String sponserName;

    private String fundingAMount;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime sponserAddedon;


    public Sponsers(int sponserId, String sponserName, String fundingAMount, LocalDateTime sponserAddedon) {
        this.sponserId = sponserId;
        this.sponserName = sponserName;
        this.fundingAMount = fundingAMount;
        this.sponserAddedon = sponserAddedon;
    }

    public Sponsers() {
    }

    public Sponsers(String sponserName, String fundingAMount) {
        this.sponserName = sponserName;
        this.fundingAMount = fundingAMount;
    }

}
