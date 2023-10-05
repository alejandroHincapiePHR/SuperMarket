package com.SuperMarket.SuperMarket.domain.finance;

import com.SuperMarket.SuperMarket.domain.admin.Customer;
import com.SuperMarket.SuperMarket.domain.admin.Employee;
import com.SuperMarket.SuperMarket.domain.base.Domain;
import com.SuperMarket.SuperMarket.domain.product.Product;
import com.SuperMarket.SuperMarket.domain.product.ProductType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public final class Bill extends Domain {
    private Date issueDate;
    private Customer customer;
    private Employee employee;
    private List<InvoiceLineItem> lineItems;
    private TotalLineItem totalLineItem;
    private Boolean isClosed;

    public Bill(Customer customer, Employee employee, Long id) {
        super(id);
        argumentCheck(customer, employee);
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


    public TotalLineItem getTotalLineItem() {
        return totalLineItem;
    }

    public void setTotalLineItem(TotalLineItem totalLineItem) {
        this.totalLineItem = totalLineItem;
    }

    private Date setIssueDate() {
        LocalDate currentDate = LocalDate.now();
        return java.sql.Date.valueOf(currentDate);
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
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
        if (lineItems == null) {
            return null;
        } else {

            return lineItems;
        }
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
        return Objects.equals(issueDate, bill.issueDate) && Objects.equals(customer, bill.customer) && Objects.equals(employee, bill.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), issueDate, customer, employee);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bill{");
        sb.append("issueDate=").append(issueDate);
        sb.append(", customer name =").append(customer.getFirstName());
        sb.append(", employee name =").append(employee.getFirstName());
        sb.append(", lineItems=").append(lineItems.toString());
        sb.append(", totalLineItem=").append(totalLineItem.toString());
        sb.append(", isClosed=").append(isClosed);
        sb.append('}');
        return sb.toString();
    }
}

