package com.itsight.epay.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.itsight.epay.domain.base.AuditingEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class TransactionSeller extends AuditingEntity {

    @Id
    private UUID id;


    @JsonManagedReference
    @OneToOne
    @MapsId
    @JoinColumn(name = "SellerCreditRequestId")
    private SellerCreditRequest sellerCreditRequest;

    @Column(nullable = false)
    private Double amount;


    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "transactionTypeId")
    private TransactionType transactionType;

}

