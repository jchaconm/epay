package com.itsight.epay.domain.base;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itsight.epay.json.JsonDateSimpleDeserializer;
import com.itsight.epay.json.JsonDateSimpleSerializer;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;

@MappedSuperclass
@Data
public class AuditingEntity {

    @Column(nullable = false, updatable = false)
    private String creador;

    @Column(nullable = false, updatable = false)
    @JsonSerialize(using = JsonDateSimpleSerializer.class)
    @JsonDeserialize(using = JsonDateSimpleDeserializer.class)
    private LocalDate fechaCreacion;

    @Column(nullable = true)
    private String modificadoPor;

    @JsonSerialize(using = JsonDateSimpleSerializer.class)
    @JsonDeserialize(using = JsonDateSimpleDeserializer.class)
    private LocalDate fechaModificacion;

    @Column(nullable = false)
    private boolean flagActivo;

    @Column(nullable = false)
    private boolean flagEliminado;

    @Column(nullable = true)
    private Long rowVersion;
}
