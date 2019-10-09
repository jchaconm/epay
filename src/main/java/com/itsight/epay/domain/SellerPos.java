package com.itsight.epay.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.itsight.epay.domain.base.AuditingEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class SellerPos extends AuditingEntity {

    @EmbeddedId
    private SellerPosKey id;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sellerPos")
    List<TransactionPos> lstTransactionPos;

}
