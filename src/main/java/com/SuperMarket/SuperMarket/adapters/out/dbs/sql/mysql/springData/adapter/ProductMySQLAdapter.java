package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.adapter;

import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.product.ProductMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.products.ProductMapper;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.repository.product.ProductMySQLRepository;
import com.SuperMarket.SuperMarket.application.ports.product.out.GetProductBySkuPort;
import com.SuperMarket.SuperMarket.application.ports.product.out.ProductCreatedPort;
import com.SuperMarket.SuperMarket.domain.product.Product;

import java.util.Optional;

public class ProductMySQLAdapter implements GetProductBySkuPort, ProductCreatedPort {

    private ProductMySQLRepository productMySQLRepository;
    private ProductMapper productMapper;


    public ProductMySQLAdapter(final ProductMySQLRepository productMySQLRepository,final ProductMapper productMapper) {
        this.productMySQLRepository = productMySQLRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Optional<Product> getProductBySKU(String SKU) {
        Optional<ProductMySQLEntity> productOptional = productMySQLRepository.findBySKU(SKU);
        if(productOptional.isEmpty()) {
            return Optional.empty();
        }
            else {
            return Optional.of(productMapper.toDomain(productOptional.get()));
        }
    }

    @Override
    public Boolean saveProduct(Product product) {

        //TODO add check for the save method
        productMySQLRepository.save(productMapper.toEntity(product));
        return Boolean.TRUE;

    }
}
