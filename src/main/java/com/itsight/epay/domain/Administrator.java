package com.itsight.epay.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Administrator {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "GeneralUserId")
    private GeneralUser generalUser;

}
