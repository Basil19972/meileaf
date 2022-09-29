package com.example.jwt.domain.test_exception;

import com.example.jwt.core.generic.ExtendedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "kunde")
public class Kunde extends ExtendedEntity {


    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "ahv", nullable = false, unique = true)
    private String ahv;


    public Kunde(String name, String email, String ahv) {
        this.name = name;
        this.email = email;
        this.ahv = ahv;
    }

    public Kunde() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAhv() {
        return ahv;
    }

    public void setAhv(String ahv) {
        this.ahv = ahv;
    }
}
