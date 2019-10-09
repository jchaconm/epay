package com.itsight.epay.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itsight.epay.json.JsonDateSimpleDeserializer;
import com.itsight.epay.json.JsonDateSimpleSerializer;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class RequestSeller {

    @Id
    private UUID id;


    @Column(nullable = false, updatable = false)
    @JsonSerialize(using = JsonDateSimpleSerializer.class)
    @JsonDeserialize(using = JsonDateSimpleDeserializer.class)
    private LocalDate requestDate;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Boolean approvalStatus;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "generalUserId",  referencedColumnName = "generalUserId")
    private Seller seller;

}
