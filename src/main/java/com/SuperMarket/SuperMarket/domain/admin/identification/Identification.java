package com.SuperMarket.SuperMarket.domain.admin.identification;

public class Identification {

    private String identificationNumber;

    private IdentificationEnum identificationEnum;

    public Identification() {
        super();
    }

    public Identification(String identificationNumber, IdentificationEnum identificationEnum) {
        super();
        this.identificationNumber = identificationNumber;
        this.identificationEnum = identificationEnum;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public IdentificationEnum getIdentificationEnum() {
        return identificationEnum;
    }

    public void setIdentificationEnum(IdentificationEnum identificationEnum) {
        this.identificationEnum = identificationEnum;
    }


}
