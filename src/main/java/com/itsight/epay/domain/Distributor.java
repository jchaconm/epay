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
public class Distributor {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "distributor")
    private List<Department> lstDepartment;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "GeneralUserId")
    private GeneralUser generalUser;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "distributor")
    private List<BackOffice> lstBackOffice;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "distributor")
    private List<Credit> lstCredit;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "distributor")
    private List<Wallet> lstWallet;
}
