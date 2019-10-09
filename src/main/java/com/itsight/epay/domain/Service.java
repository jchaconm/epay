package com.itsight.epay.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.itsight.epay.domain.Supplier;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Service {

   @Id
   private UUID id;

   @Column(nullable =  false)
   private String name;

   @JsonManagedReference
   @ManyToOne
   @JoinColumn(name = "GeneralUserId")
   private Supplier supplier;
}
