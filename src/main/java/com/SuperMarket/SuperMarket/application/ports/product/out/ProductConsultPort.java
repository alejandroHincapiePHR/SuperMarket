package com.SuperMarket.SuperMarket.application.ports.product.out;

import com.SuperMarket.SuperMarket.domain.product.Product;

@FunctionalInterface
public interface ProductConsultPort {
    Product getProductBySKU(String SKU);
}
