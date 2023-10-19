package com.SuperMarket.SuperMarket.application.ports.product.in;

import com.SuperMarket.SuperMarket.domain.product.Product;

import java.util.List;
import java.util.Optional;

@FunctionalInterface
public interface SkuListToProductListUseCase {

    List<Product> skuListToProductList(List<String> skuList);
}
