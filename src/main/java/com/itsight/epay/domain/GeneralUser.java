package com.itsight.epay.domain;

import com.itsight.epay.domain.base.AuditingEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
public class GeneralUser  extends AuditingEntity implements Serializable {

 @Id
 private UUID id;

 @Column(nullable = false)
 private String username;

 @Column(nullable = false)
 private String password;

 @Column(nullable = false)
 private Boolean enabled;

}
