package com.itsight.epay.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.itsight.epay.domain.base.AuditingEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class TransactionPos extends AuditingEntity {

    @Id
    private UUID id;

    @Column(nullable = false)
    private Double amount;


    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "transactionTypeId")
    private TransactionType transactionType;

    @JsonManagedReference
    @ManyToOne
    @JoinColumns({
        @JoinColumn( name = "sellerId", referencedColumnName = "sellerId"),
        @JoinColumn( name = "posId", referencedColumnName = "posId")
    })
    private SellerPos sellerPos;

    @JsonManagedReference
    @ManyToOne
    @JoinColumns({
            @JoinColumn( name = "serviceId", referencedColumnName = "serviceId"),
            @JoinColumn( name = "distributorId", referencedColumnName = "distributorId")
    })
    private ServiceDistributor serviceDistributor;

}
