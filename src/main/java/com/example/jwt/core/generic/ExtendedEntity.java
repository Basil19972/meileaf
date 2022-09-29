package com.example.jwt.core.generic;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public abstract class ExtendedEntity {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @Type(type = "uuid-char") // For testing purposes only. H2 does not support binary UUID.
    private UUID id = UUID.randomUUID();


    protected ExtendedEntity() {
    }

    protected ExtendedEntity(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}