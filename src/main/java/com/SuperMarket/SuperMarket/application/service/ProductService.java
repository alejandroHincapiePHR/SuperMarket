package com.SuperMarket.SuperMarket.application.service;

import com.SuperMarket.SuperMarket.application.exceptions.ProductNotFoundException;
import com.SuperMarket.SuperMarket.application.ports.product.in.ProductCreationUseCase;
import com.SuperMarket.SuperMarket.application.ports.product.in.GetProductBySkuUseCase;
import com.SuperMarket.SuperMarket.application.ports.product.in.SkuListToProductListUseCase;
import com.SuperMarket.SuperMarket.application.ports.product.out.GetProductBySkuPort;
import com.SuperMarket.SuperMarket.application.ports.product.out.ProductCreatedPort;
import com.SuperMarket.SuperMarket.domain.product.Product;
import com.SuperMarket.SuperMarket.domain.product.ProductType;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ProductService implements ProductCreationUseCase, GetProductBySkuUseCase, SkuListToProductListUseCase {

    private ProductCreatedPort productCreatedPort;
    private GetProductBySkuPort getProductBySkuPort;


    public ProductService(ProductCreatedPort productCreatedPort,
                          GetProductBySkuPort getProductBySkuPort) {
        this.productCreatedPort = productCreatedPort;
        this.getProductBySkuPort = getProductBySkuPort;
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
    public Optional<Product> getProductBySku(String SKU) {
        return getProductBySkuPort.getProductBySKU(SKU);
    }

    @Override
    public List<Product> skuListToProductList(List<String> skuList) throws ProductNotFoundException {
       List<Optional<Product>> productListOptional= skuList.stream().map(x->getProductBySkuPort.getProductBySKU(x)).toList();
       productListOptional.stream().forEach(x->{
            if(x.isEmpty()){
                throw new ProductNotFoundException();
            }
        });
       return productListOptional.stream().map(x->x.get()).toList();
    }
}
