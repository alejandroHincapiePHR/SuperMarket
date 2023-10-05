package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.administration.implementations;

import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.administration.Interfaces.PersonMapper;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.administration.PersonMySQLEntity;
import com.SuperMarket.SuperMarket.domain.admin.Person;



public class PersonMapperImp implements PersonMapper {

    @Override
    public Person toDomain(PersonMySQLEntity p) {
        Person person = new Person(p.getFirstName(), p.getLastName(), p.getEmail(), p.getTelefonNumber());
        person.setId(p.getId());
        return person;
    }

    @Override
    public PersonMySQLEntity toEntity(Person p) {
        PersonMySQLEntity person = new PersonMySQLEntity(null, p.getFirstName(), p.getLastName(), p.getEmail(), p.getTelefonNumber());
        return person;
    }
}
