package com.itsight.epay.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itsight.epay.domain.base.AuditingEntity;
import com.itsight.epay.json.JsonDateSimpleDeserializer;
import com.itsight.epay.json.JsonDateSimpleSerializer;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class SellerCreditRequest extends AuditingEntity {


    @Id
    private UUID id;

    @Column(nullable = false)
    private Double amount;


    @Column(nullable = false, updatable = false)
    @JsonSerialize(using = JsonDateSimpleSerializer.class)
    @JsonDeserialize(using = JsonDateSimpleDeserializer.class)
    private LocalDate approvalDate;


    @Column(nullable = false, updatable = false)
    @JsonSerialize(using = JsonDateSimpleSerializer.class)
    @JsonDeserialize(using = JsonDateSimpleDeserializer.class)
    private LocalDate denialDate;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn( name = "GeneralUserId")
    private Seller seller;






}
