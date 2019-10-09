package com.itsight.epay.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
public class ServiceDistributorKey implements Serializable {

    @Column(name = "serviceId")
    private UUID serviceId;

    @Column(name = "distributorId")
    private UUID distributorId;

}
