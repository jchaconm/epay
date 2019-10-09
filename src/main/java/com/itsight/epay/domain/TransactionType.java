package com.itsight.epay.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class TransactionType {

    @Id
    private UUID id;

    @Column( nullable = false)
    private String name;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "transactionType")
    private List<TransactionSeller> lstTransactionSeller;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "transactionType")
    private List<TransactionPos> lstTransactionPos;


    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "transactionType")
    private List<Transaction> lstTransaction;



}
