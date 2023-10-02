package com.SuperMarket.SuperMarket.application.billing.ports.product.out;

import com.SuperMarket.SuperMarket.domain.product.Product;
@FunctionalInterface
public interface ProductCreatedPort {
    Boolean saveProduct(Product product);
}
