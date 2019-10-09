package com.itsight.epay.domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Pos {
    @Id
    private UUID id;

    @Column(nullable = false)
    private String documento;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable =  false)
    private String lastName;

    @JsonBackReference
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "pos")
    private List<RequestPos> lstRequestPos;
}
