package com.itsight.epay.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.itsight.epay.domain.base.AuditingEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Wallet extends AuditingEntity {

  @Id
  private UUID id;

  @Column( nullable = false)
  private Double amount;

  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "GeneralUserId")
  private Distributor distributor;

  @JsonBackReference
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "wallet")
  private List<Transaction> lstTransaction;

}
