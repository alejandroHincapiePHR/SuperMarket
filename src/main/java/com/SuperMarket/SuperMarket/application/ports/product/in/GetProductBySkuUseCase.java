package com.SuperMarket.SuperMarket.application.ports.product.in;

import com.SuperMarket.SuperMarket.domain.product.Product;

import java.util.Optional;

@FunctionalInterface
public interface GetProductBySkuUseCase {
    Optional<Product> getProductBySku(String SKU);
}
