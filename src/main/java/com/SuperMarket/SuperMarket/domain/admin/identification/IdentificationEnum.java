package com.SuperMarket.SuperMarket.domain.admin.identification;

public enum IdentificationEnum {
    CC("CC","Cedula de ciudadania"),
    TI("TI","Tarjeta de identidad"),
    RC("RC","Registro civil"),
    CE("CE","Cedula de extranjeria"),
    CI("CI","Carnet de identidad"),
    DNI("DNI", "Documento nacional de identidad");

    private final String abv;
    private final String description;

    IdentificationEnum(String abv, String description) {
        this.abv = abv;
        this.description = description;
    }

    public String getAbv() {
        return abv;
    }

    public String getDescription() {
        return description;
    }

  }
