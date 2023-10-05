package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.repository.administration;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.administration.EmployeeMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.repository.base.GenericMySQLRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMySQLRepository extends GenericMySQLRepository<EmployeeMySQLEntity, Long> {
}
