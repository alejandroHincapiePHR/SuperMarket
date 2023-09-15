package com.SuperMarket.SuperMarket.domain.finance;

import com.SuperMarket.SuperMarket.domain.admin.Customer;
import com.SuperMarket.SuperMarket.domain.admin.Employee;
import com.SuperMarket.SuperMarket.domain.base.Domain;

import java.util.Date;
import java.util.List;

public final class Bill extends Domain {
    private int billNumber;
    private Date issueDate;
    private Customer customer;
    private Employee employee;
    private List<InvoiceLineItem> lineItems;
}

