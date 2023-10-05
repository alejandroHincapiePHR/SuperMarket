package com.SuperMarket.SuperMarket.application.ports.admin.customer.in;

import com.SuperMarket.SuperMarket.domain.admin.Customer;

@FunctionalInterface
public interface CustomerByIdUseCase {

    Customer customerById(Long id);

}
