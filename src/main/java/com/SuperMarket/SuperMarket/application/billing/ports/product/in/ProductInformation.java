package com.SuperMarket.SuperMarket.application.billing.ports.product.in;

import com.SuperMarket.SuperMarket.domain.product.Product;

@FunctionalInterface
public interface ProductInformation {
    Product getProductBySku(String SKU);
}
