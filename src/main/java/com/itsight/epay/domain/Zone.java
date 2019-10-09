package com.itsight.epay.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Zone {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name= "DepartmentId")
    private Department department;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "zone")
    List<ZoneSupervisor> lstZoneSupervisors;


    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "zone")
    List<Seller> lstSellers;

}
