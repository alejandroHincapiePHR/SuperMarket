package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.base;

public interface GenericMapper<D,E>{
    D toDomain(E e);
    E toEntity(D d);
}
