package com.itsight.epay.domain;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class BackOffice {

  @Id
  private UUID id;

  @Column( nullable = false)
  private String firstName;

  @Column( nullable = false)
  private String lastName;

  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "GeneralUserId")
  private Distributor distributor;

  @JsonManagedReference
  @OneToMany( fetch = FetchType.LAZY ,  mappedBy = "backOffice")
  private List<IncreaseRequestApproval> lstIncreaseRequestApproval;


  @JsonManagedReference
  @OneToMany( fetch = FetchType.LAZY ,  mappedBy = "backOffice")
  private List<SellerIncreaseRequestApproval> lstSellerIncreaseRequestApproval;

}
