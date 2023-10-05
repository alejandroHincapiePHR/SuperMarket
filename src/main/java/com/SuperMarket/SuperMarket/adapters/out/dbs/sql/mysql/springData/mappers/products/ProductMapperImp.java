package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.products;

import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.product.ProductMySQLEntity;
import com.SuperMarket.SuperMarket.domain.product.Product;
import com.SuperMarket.SuperMarket.domain.product.ProductType;
import org.springframework.stereotype.Component;


public class ProductMapperImp implements ProductMapper{
    @Override
    public Product toDomain(ProductMySQLEntity p) {
        //ToDo Set the case when productType is not a valid value
        ProductType productType = ProductType.valueOf(p.getProductType());
        Product product = new Product(p.getSKU(), p.getExpirationDate(), p.getProductName(), p.getProductManufacturer(),
                productType, p.getAvailableUnits(), p.getCustomerCost(), p.getCompanyCost());
        product.setId(p.getId());
        return product;
    }
    @Override
    public ProductMySQLEntity toEntity(Product p) {
        ProductMySQLEntity productMySQLEntity =  new ProductMySQLEntity(p.getId(), p.getSKU(), p.getExpirationDate(), p.getProductName(),
                p.getProductManufacturer(), p.getProductType().toString(), p.getAvailableUnits(), p.getCustomerCost(),
                p.getCompanyCost());
        return productMySQLEntity;
    }
}
