package com.example.reservationhotel.model.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdAt","UpdateAt"},allowGetters = true
)


public abstract class UserDateAudit implements Serializable {
    private static final long serialVersionUID = 1L;
    @CreatedBy
    @Column(updatable = false)
    private Long createdBy;

    @LastModifiedDate
    private Long updatedBy;

}
