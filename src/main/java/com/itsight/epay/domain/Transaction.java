package com.itsight.epay.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Transaction {

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
  @JoinColumn(name = "walletId")
  private Wallet wallet;





}
