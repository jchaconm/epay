package com.itsight.epay.domain;


import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@Data
public class SellerPosKey implements Serializable {

    @JoinColumn( name = "seller_id")
    private UUID sellerId;

    @JoinColumn( name = "pos_id")
    private UUID posId;

    @Override
    public int hashCode() {
        return Objects.hash(getSellerId(), getPosId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SellerPosKey)) return false;
        SellerPosKey sellerPosKey = (SellerPosKey) o;
        return Objects.equals(getSellerId(), sellerPosKey.getSellerId()) &&
                Objects.equals(getPosId(), sellerPosKey.getPosId());
    }

}
