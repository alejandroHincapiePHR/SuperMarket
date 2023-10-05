package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.repository.administration;

import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.administration.PersonMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.repository.base.GenericMySQLRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMySQLRepository extends GenericMySQLRepository<PersonMySQLEntity, Long> {
}
