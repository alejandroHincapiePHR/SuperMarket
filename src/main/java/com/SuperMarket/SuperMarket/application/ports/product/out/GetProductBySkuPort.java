package com.SuperMarket.SuperMarket.application.ports.product.out;

import com.SuperMarket.SuperMarket.domain.product.Product;

import java.util.Optional;

@FunctionalInterface
public interface GetProductBySkuPort {
    Optional<Product> getProductBySKU(String SKU);
}
