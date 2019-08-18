package com.mz.example.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mz.example.db.Columns;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
//We’ll use JPA’s AuditingEntityListener to automatically populate createdAt and updatedAt
// values when we persist an entity.
//TODO: read about this
@EntityListeners(AuditingEntityListener.class)
public abstract class DateAudit implements Serializable {

    @CreatedDate
    @Column(name = Columns.CREATED_AT, nullable = false, updatable = false)
    @JsonIgnore
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = Columns.UPDATED_AT, nullable = false)
    @JsonIgnore
    private Instant updatedAt;
}
