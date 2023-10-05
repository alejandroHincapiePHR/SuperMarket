package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.adapter;

import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.administration.CustomerMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.administration.Interfaces.CustomerMapper;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.repository.administration.CustomerMySQLRepository;
import com.SuperMarket.SuperMarket.application.ports.admin.customer.out.CustomerByIdPort;
import com.SuperMarket.SuperMarket.domain.admin.Customer;
import java.util.Optional;


public class CustomerMySQLAdapter implements CustomerByIdPort {

    private CustomerMySQLRepository customerMySQLRepository;
    private CustomerMapper customerMapper;


    public CustomerMySQLAdapter(final CustomerMySQLRepository customerMySQLRepository, final CustomerMapper customerMapper) {
        this.customerMySQLRepository = customerMySQLRepository;
        this.customerMapper = customerMapper;
    }


    @Override
    public Customer getCustomerById(Long id) {
        Optional<CustomerMySQLEntity> customerEntity = customerMySQLRepository.findById(id);

        if (customerEntity.isPresent()) {
            return customerMapper.toDomain(customerEntity.get());
        } else {
            return null;
        }
    }
}
