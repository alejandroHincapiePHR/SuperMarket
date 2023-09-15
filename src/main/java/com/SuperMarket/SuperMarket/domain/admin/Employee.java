package com.SuperMarket.SuperMarket.domain.admin;

import com.SuperMarket.SuperMarket.domain.admin.identification.Identification;
import com.SuperMarket.SuperMarket.domain.admin.position.PositionEnum;

public non-sealed class Employee extends Person {
    private PositionEnum position;
    private Integer Salary;

    public Employee() {
        super();
    }

    public Employee(String firstName, String lastName, Identification identification, String email, String telefonNumber,
                    PositionEnum position, Integer salary) {
        super(firstName, lastName, identification, email, telefonNumber);
        this.position = position;
        Salary = salary;
    }
}
