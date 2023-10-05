package com.SuperMarket.SuperMarket.domain.admin;

import com.SuperMarket.SuperMarket.domain.admin.identification.Identification;
import com.SuperMarket.SuperMarket.domain.base.Domain;

import java.util.Objects;

public class Person extends Domain {
    private String firstName;
    private String lastName;
    private Identification identification;
    private String email;
    private String telefonNumber;

    public Person(){
        super();
    }

    public Person(String firstName, String lastName, String email, String telefonNumber) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telefonNumber = telefonNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonNumber() {
        return telefonNumber;
    }

    public void setTelefonNumber(String telefonNumber) {
        this.telefonNumber = telefonNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(identification, person.identification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), identification);
    }
}
