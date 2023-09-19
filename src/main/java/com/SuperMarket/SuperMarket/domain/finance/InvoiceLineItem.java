package com.SuperMarket.SuperMarket.domain.finance;

import com.SuperMarket.SuperMarket.domain.finance.discountLogic.configUtil.DiscountConfigReader;
import com.SuperMarket.SuperMarket.domain.finance.util.ConfigReader;
import com.SuperMarket.SuperMarket.domain.product.Product;
import com.SuperMarket.SuperMarket.domain.product.ProductType;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public final class InvoiceLineItem {

    private static final ConfigReader configReader = new ConfigReader();
    private static final DiscountConfigReader discountConfigReader = new DiscountConfigReader();
    private Product product;
    private Integer quantity;
    private Double taxes;
    private Double discount;
    private Double subtotal;
    private Double points;
    private Double taxesPCT;
    private Double pointsPCT;
    private Double discountPCT;

    public InvoiceLineItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
        this.taxesPCT = getTaxesFromFile();
        this.pointsPCT = getPointsFromFile();
        this.discountPCT = getDiscountFromFile(product.getProductType());
        this.points = calculateSubTotalPoints(product.getCustomerCost(), quantity);
        this.taxes = calculateSubTotalTaxes(product.getCustomerCost(), quantity);
        this.discount = calculateSubTotalDiscount(product.getCustomerCost(), quantity);
        this.subtotal = calculateSubTotal(product.getCustomerCost(), quantity);
    }
    private Double calculateSubTotal(Double customerCost, Integer quantity) {
        return (customerCost+(taxes)-(discount))*quantity;

    }
    private Double calculateSubTotalDiscount(Double customerCost, Integer quantity) {
        return customerCost*discountPCT*quantity;
    }
    private Double calculateSubTotalTaxes(Double customerCost, Integer quantity) {
        return customerCost*taxesPCT*quantity;
    }

    private Double calculateSubTotalPoints(Double customerCost, Integer quantity) {
        return customerCost*pointsPCT*quantity;
    }

    private Double getDiscountFromFile(ProductType productType) {
        String[] chainValues = discountConfigReader.loadConfig("discount.properties", productType.toString());
        if (chainValues[0] == getDayInUpperCase()){
            return Double.parseDouble(chainValues[1]);
        }
        else {
            return 0D;
        }
    }

    private String getDayInUpperCase() {
        LocalDate currentDate = LocalDate.now();
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        String dayInUpperCase = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH).toUpperCase();
        return dayInUpperCase;
    }

    private double getTaxesFromFile() {
        String parameter = "taxes";
        configReader.loadConfig("config.properties", parameter);
        double taxes = configReader.getParameterValue();
        return taxesPCT;
    }

    private double getPointsFromFile() {
        String parameter = "points";
        configReader.loadConfig("config.properties", parameter);
        double points = configReader.getParameterValue();
        return pointsPCT;
    }


}
