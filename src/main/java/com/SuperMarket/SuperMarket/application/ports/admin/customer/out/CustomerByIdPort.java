package com.SuperMarket.SuperMarket.application.ports.admin.customer.out;

import com.SuperMarket.SuperMarket.domain.admin.Customer;

import java.util.Optional;

@FunctionalInterface
public interface CustomerByIdPort {

    Optional<Customer> getCustomerById(Long id);
}
