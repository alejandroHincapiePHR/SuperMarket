package com.SuperMarket.SuperMarket.application.ports.bill.in;

import com.SuperMarket.SuperMarket.domain.admin.Customer;
import com.SuperMarket.SuperMarket.domain.admin.Employee;
import com.SuperMarket.SuperMarket.domain.finance.Bill;

@FunctionalInterface
public interface BillInitialization {

    Bill billInitialization(Customer customer, Employee employee);


}
