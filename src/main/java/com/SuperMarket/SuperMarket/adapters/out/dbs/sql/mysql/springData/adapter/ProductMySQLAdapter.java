package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.adapter;

import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.products.ProductMapper;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.repository.product.ProductMySQLRepository;
import com.SuperMarket.SuperMarket.application.ports.product.out.ProductConsultPort;
import com.SuperMarket.SuperMarket.application.ports.product.out.ProductCreatedPort;
import com.SuperMarket.SuperMarket.domain.product.Product;

public class ProductMySQLAdapter implements ProductConsultPort, ProductCreatedPort {

    private ProductMySQLRepository productMySQLRepository;
    private ProductMapper productMapper;


    public ProductMySQLAdapter(final ProductMySQLRepository productMySQLRepository,final ProductMapper productMapper) {
        this.productMySQLRepository = productMySQLRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product getProductBySKU(String SKU) {
        return productMapper.toDomain(productMySQLRepository.findBySKU(SKU));
    }

    @Override
    public Boolean saveProduct(Product product) {

        //TODO add check for the save method
        productMySQLRepository.save(productMapper.toEntity(product));
        return Boolean.TRUE;

    }
}
