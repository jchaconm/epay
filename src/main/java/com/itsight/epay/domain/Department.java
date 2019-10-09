package com.itsight.epay.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import net.bytebuddy.dynamic.TypeResolutionStrategy;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Department {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "GeneralUserId")
    private Distributor distributor;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    List<DepartmentSupervisor> lstDepartmentSupervisor;


}
