package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.products;

import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.product.ProductMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.base.GenericMapper;
import com.SuperMarket.SuperMarket.domain.product.Product;

public interface ProductMapper extends GenericMapper<Product, ProductMySQLEntity> {
}
