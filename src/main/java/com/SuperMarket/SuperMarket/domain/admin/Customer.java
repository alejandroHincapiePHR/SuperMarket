package com.SuperMarket.SuperMarket.domain.admin;

import com.SuperMarket.SuperMarket.domain.admin.identification.Identification;
import com.SuperMarket.SuperMarket.domain.finance.Bill;

import java.util.ArrayList;
import java.util.List;

public non-sealed class Customer extends Person {

    private boolean isEmployee;

    private Integer points;

    private List<Bill> clientBills;

    public Customer() {
        super();
    }

    public Customer(String firstName, String lastName, Identification identification, String email, String telefonNumber) {
        super(firstName, lastName, identification, email, telefonNumber);
        this.points = 0;
        this.clientBills = new ArrayList<>();
        this.isEmployee = false;
    }


    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setClientBills(List<Bill> clientBills) {
        this.clientBills = clientBills;
    }

    public Integer getPoints() {
        return points;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public List<Bill> getClientBills() {
        return clientBills;
    }
}
