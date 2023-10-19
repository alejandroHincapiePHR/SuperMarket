package com.SuperMarket.SuperMarket.application.ports.bill.in;

import com.SuperMarket.SuperMarket.domain.admin.Customer;
import com.SuperMarket.SuperMarket.domain.admin.Employee;
import com.SuperMarket.SuperMarket.domain.product.Product;

import java.util.List;

@FunctionalInterface
public interface BillCreationUseCase {

    Long billCreationUseCase(Employee employee, Customer customer, List<Product> products);

}
