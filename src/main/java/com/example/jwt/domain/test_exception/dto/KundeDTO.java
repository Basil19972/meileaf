package com.example.jwt.domain.test_exception.dto;
import com.example.jwt.core.exception.Validierung.AHVNrValidation;
import com.example.jwt.core.generic.ExtendedDTO;
import javax.validation.constraints.Email;

public class KundeDTO extends ExtendedDTO {

    private String name;

    @Email
    private String email;

    @AHVNrValidation
    private String ahv;

    public KundeDTO(String name, String email, String ahv) {
        this.name = name;
        this.email = email;
        this.ahv = ahv;
    }

    public KundeDTO() {
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
