package com.SuperMarket.SuperMarket.application.service;

import com.SuperMarket.SuperMarket.application.exceptions.CustomerNotFoundException;
import com.SuperMarket.SuperMarket.application.ports.admin.customer.in.CustomerByIdUseCase;
import com.SuperMarket.SuperMarket.application.ports.admin.customer.out.CustomerByIdPort;
import com.SuperMarket.SuperMarket.domain.admin.Customer;

import java.util.Optional;


public class CustomerService implements CustomerByIdUseCase {
    private CustomerByIdPort customerByIdPort;

    public CustomerService(final CustomerByIdPort customerByIdPort) {
        this.customerByIdPort = customerByIdPort;
    }

    @Override
    public Customer customerById(Long id) throws CustomerNotFoundException {
        Optional<Customer> customerOptional = customerByIdPort.getCustomerById(id);
        if(customerOptional.isEmpty()){
            throw new CustomerNotFoundException();
        }
        return customerOptional.get();
    }
}
