package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.repository.administration;

import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.administration.CustomerMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.repository.base.GenericMySQLRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMySQLRepository extends GenericMySQLRepository<CustomerMySQLEntity,Long> {
}
