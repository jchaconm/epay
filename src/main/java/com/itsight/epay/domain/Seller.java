package com.itsight.epay.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.itsight.epay.domain.base.AuditingEntity;
import lombok.Data;
import org.springframework.expression.spel.ast.NullLiteral;

import javax.persistence.*;
import javax.swing.text.StyledEditorKit;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Seller extends AuditingEntity {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;


    @Column(nullable = false)
    private Boolean isSupervisorSeller;


    @Column(nullable = true)
    private UUID superVisorId;

    @Column(nullable = true)
    private int supervisorType;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "ZoneId")
    private Zone zone;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "GeneralUserId")
    private GeneralUser generalUser;


    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "seller")
    private List<RequestSeller> lstRequestSeller;


}
