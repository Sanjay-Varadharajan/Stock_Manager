package com.example.Stock_Manager.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Partners {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int partnerId;

    private String partnerName;

    private double percentage;

    private String partnerphoneNumber;


    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime partneredOn;




}
