package com.itsight.epay.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itsight.epay.domain.base.AuditingEntity;
import com.itsight.epay.json.JsonDateSimpleDeserializer;
import com.itsight.epay.json.JsonDateSimpleSerializer;
import lombok.Data;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.sound.sampled.AudioFileFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class ServiceDistributor extends AuditingEntity {

    @EmbeddedId
    private ServiceDistributorKey id;

    @Column(nullable = false)
    private Double commission;


    @Column(nullable = false, updatable = false)
    @JsonSerialize(using = JsonDateSimpleSerializer.class)
    @JsonDeserialize(using = JsonDateSimpleDeserializer.class)
    private LocalDate date;

    @JsonBackReference
    @OneToMany( fetch = FetchType.LAZY, mappedBy =  "serviceDistributor")
    private List<TransactionPos> lstTransactionPos;

}
