package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.repository.product;

import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.product.ProductMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.repository.base.GenericMySQLRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductMySQLRepository extends GenericMySQLRepository<ProductMySQLEntity, Long> {


    Optional<ProductMySQLEntity> findBySKU(String SKU);

}
