package com.SuperMarket.SuperMarket.application.ports.product.in;

import com.SuperMarket.SuperMarket.domain.product.Product;

@FunctionalInterface
public interface ProductInformation {
    Product getProductBySku(String SKU);
}
