package com.SuperMarket.SuperMarket.domain.product;

import com.SuperMarket.SuperMarket.domain.base.Domain;

import java.util.Date;
import java.util.Objects;

public final class Product extends Domain {

    private String SKU;
    private Date expirationDate;
    private String productName;
    private String productManufacturer;
    private ProductType productType;
    private Integer availableUnits;
    private Double customerCost;
    private Double companyCost;

    public Product() {
        super();
    }

    public Product(String SKU, Date expirationDate, String productName, String productManufacturer,
                   ProductType productType, Integer availableUnits,Double customerCost,Double companyCost) {
        super();
        this.SKU = SKU;
        this.expirationDate = expirationDate;
        this.productName = productName;
        this.productManufacturer = productManufacturer;
        this.productType = productType;
        this.availableUnits = availableUnits;
        this.customerCost = customerCost;
        this.companyCost=companyCost;
    }


    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Integer getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(Integer availableUnits) {
        this.availableUnits = availableUnits;
    }

    public Double getCustomerCost() {
        return customerCost;
    }

    public void setCustomerCost(Double customerCost) {
        this.customerCost = customerCost;
    }

    public Double getCompanyCost() {
        return companyCost;
    }

    public void setCompanyCost(Double companyCost) {
        this.companyCost = companyCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(SKU, that.SKU);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, SKU);
    }
}
