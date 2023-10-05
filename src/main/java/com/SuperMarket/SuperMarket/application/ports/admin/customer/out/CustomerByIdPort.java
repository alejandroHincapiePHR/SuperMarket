package com.SuperMarket.SuperMarket.application.ports.admin.customer.out;

import com.SuperMarket.SuperMarket.domain.admin.Customer;

@FunctionalInterface
public interface CustomerByIdPort {

    Customer getCustomerById(Long id);
}
