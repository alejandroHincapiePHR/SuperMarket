package com.SuperMarket.SuperMarket.application.ports.product.in;

import com.SuperMarket.SuperMarket.domain.product.Product;
import com.SuperMarket.SuperMarket.domain.product.ProductType;

import java.util.Date;

@FunctionalInterface
public interface ProductCreationUseCase {

    Product createProduct(String SKU, Date expirationDate, String productName, String productManufacturer,
                          ProductType productType, Integer availableUnits, Double customerCost, Double companyCost);


}
