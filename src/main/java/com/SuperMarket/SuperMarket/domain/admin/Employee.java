package com.SuperMarket.SuperMarket.domain.admin;

import com.SuperMarket.SuperMarket.domain.admin.identification.Identification;
import com.SuperMarket.SuperMarket.domain.admin.position.PositionEnum;

public class Employee extends Person {
    private PositionEnum position;
    private Integer Salary;

    public Employee() {
        super();
    }

    public Employee(String firstName, String lastName, String email, String telefonNumber,
                    PositionEnum position, Integer salary) {
        super(firstName, lastName, email, telefonNumber);
        this.position = position;
        Salary = salary;
    }

    public PositionEnum getPosition() {
        return position;
    }

    public void setPosition(PositionEnum position) {
        this.position = position;
    }

    public Integer getSalary() {
        return Salary;
    }

    public void setSalary(Integer salary) {
        Salary = salary;
    }
}
