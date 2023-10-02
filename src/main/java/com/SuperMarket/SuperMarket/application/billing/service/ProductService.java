package com.SuperMarket.SuperMarket.application.billing.service;

import com.SuperMarket.SuperMarket.application.billing.ports.product.in.ProductCreation;
import com.SuperMarket.SuperMarket.application.billing.ports.product.in.ProductInformation;
import com.SuperMarket.SuperMarket.application.billing.ports.product.out.ProductConsultPort;
import com.SuperMarket.SuperMarket.application.billing.ports.product.out.ProductCreatedPort;
import com.SuperMarket.SuperMarket.domain.product.Product;
import com.SuperMarket.SuperMarket.domain.product.ProductType;

import java.util.Date;

public class ProductService implements ProductCreation, ProductInformation {

    private ProductCreatedPort productCreatedPort;
    private ProductConsultPort productConsultPort;

    public ProductService(final ProductCreatedPort productCreatedPort,
                          final ProductConsultPort productConsultPort ) {
        this.productCreatedPort = productCreatedPort;
        this.productConsultPort = productConsultPort;
    }

    @Override
    public Product createProduct(String SKU, Date expirationDate, String productName,
                                 String productManufacturer, ProductType productType,
                                 Integer availableUnits, Double customerCost, Double companyCost) {
        Product product = new Product(SKU, expirationDate, productName, productManufacturer, productType, availableUnits,
                customerCost, companyCost);
        productCreatedPort.saveProduct(product);
        return product;
    }

    @Override
    public Product getProductBySku(String SKU) {
        Product product = productConsultPort.getProductBySKU(SKU);
        return product;
    }
}
