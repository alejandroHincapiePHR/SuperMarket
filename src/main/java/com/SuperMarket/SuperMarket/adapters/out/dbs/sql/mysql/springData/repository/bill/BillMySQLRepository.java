package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.repository.bill;

import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.bill.BillMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.repository.base.GenericMySQLRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillMySQLRepository extends GenericMySQLRepository<BillMySQLEntity, Long> {
}
