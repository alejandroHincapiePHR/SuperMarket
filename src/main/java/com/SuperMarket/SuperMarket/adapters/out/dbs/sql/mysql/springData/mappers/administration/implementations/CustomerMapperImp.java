package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.administration.implementations;

import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.administration.Interfaces.CustomerMapper;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.administration.CustomerMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.administration.PersonMySQLEntity;
import com.SuperMarket.SuperMarket.domain.admin.Customer;



public class CustomerMapperImp implements CustomerMapper {

    @Override
    public Customer toDomain(CustomerMySQLEntity c) {

        Customer customer = new Customer(c.getPerson().getFirstName(), c.getPerson().getLastName(),
                c.getPerson().getEmail(),c.getPerson().getTelefonNumber());
        customer.setPoints(c.getPoints());
        customer.setId(c.getCustomerId());
        return customer;
    }

    @Override
    public CustomerMySQLEntity toEntity(Customer c) {
        PersonMySQLEntity person = new PersonMySQLEntity(null, c.getFirstName(), c.getLastName(), c.getEmail(),
                c.getEmail());
        CustomerMySQLEntity customerMySQLEntity = new CustomerMySQLEntity(null, c.getPoints(), person);
        return customerMySQLEntity;
    }
}
