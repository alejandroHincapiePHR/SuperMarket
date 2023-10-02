package com.SuperMarket.SuperMarket.domain.finance;

import com.SuperMarket.SuperMarket.domain.admin.Customer;
import com.SuperMarket.SuperMarket.domain.admin.Employee;
import com.SuperMarket.SuperMarket.domain.base.Domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Bill extends Domain {

    private static Long counter = 0L;
    private Long billNumber;
    private String issueDate;
    private Customer customer;
    private Employee employee;
    private List<InvoiceLineItem> lineItems;
    private TotalLineItem totalLineItem;

    private Boolean isClosed;

    public Bill(Customer customer, Employee employee) {
        super();
        argumentCheck(customer, employee);
        this.id = ++counter;
        this.billNumber = id + 10;
        this.customer = customer;
        this.employee = employee;
        this.issueDate = setIssueDate();
        this.lineItems = new ArrayList<>();
        this.isClosed = false;
    }

    private static void argumentCheck(Customer customer, Employee employee) {
        if (customer == null || employee == null) {
            throw new IllegalArgumentException("Data arguments are not valid");
        }
    }

    public void confirmBillAndGetTotalLineItem(Boolean isEmployee) {
        if (isEmployee == null) {
            throw new IllegalArgumentException("Data arguments are not valid");
        }
        isClosed = true;
        totalLineItem = new TotalLineItem(lineItems, isEmployee);

    }

    private String setIssueDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return currentDate.format(dateTimeFormatter);
    }

    public static long getCounter() {
        return counter;
    }

    public static void setCounter(long counter) {
        Bill.counter = counter;
    }

    public long getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(long billNumber) {
        this.billNumber = billNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<InvoiceLineItem> getLineItems() {
        return lineItems;
    }

    public Boolean setLineItem(InvoiceLineItem lineItem) {
        if (lineItem != null) {
            this.lineItems.add(lineItem);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bill bill)) return false;
        if (!super.equals(o)) return false;
        return billNumber == bill.billNumber && Objects.equals(issueDate, bill.issueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), billNumber, issueDate);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bill{");
        sb.append("billNumber=").append(billNumber);
        sb.append(", issueDate=").append(issueDate);
        sb.append(", customer=").append(customer);
        sb.append(", employee=").append(employee);
        sb.append(", lineItems=").append(lineItems);
        sb.append(", id=").append(id);
        sb.append(", stateEnum=").append(stateEnum);
        sb.append('}');
        return sb.toString();
    }
}

