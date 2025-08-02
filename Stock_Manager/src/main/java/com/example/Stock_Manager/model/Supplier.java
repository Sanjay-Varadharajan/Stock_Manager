package com.example.Stock_Manager.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int supplierId;

    private String supplierName;

    private String supplierAddress;

    private String supplierPhone;

    private String supplierMail;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime suppliercreatedon;

    private String accountNo;


    @OneToMany(mappedBy = "supplier" ,cascade = CascadeType.ALL)
    private List<Orders> ordersList;

    public Supplier(int supplierId, String supplierName, String supplierAddress, String supplierPhone, String supplierMail, LocalDateTime suppliercreatedon, String accountNo) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierPhone = supplierPhone;
        this.supplierMail = supplierMail;
        this.suppliercreatedon = suppliercreatedon;
        this.accountNo = accountNo;
    }

    public Supplier() {
    }

    public Supplier(String accountNo, String supplierMail, String supplierPhone, String supplierAddress, String supplierName) {
        this.accountNo = accountNo;
        this.supplierMail = supplierMail;
        this.supplierPhone = supplierPhone;
        this.supplierAddress = supplierAddress;
        this.supplierName = supplierName;
    }
}
