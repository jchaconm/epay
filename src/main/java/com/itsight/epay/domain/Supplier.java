package com.itsight.epay.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.itsight.epay.Credit;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Supplier {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "GeneralUserId")
    private GeneralUser generalUser;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "supplier")
    private List<Service> lstServicios;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "supplier")
    private List<Credit> lstCredit;

}
