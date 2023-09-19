package com.SuperMarket.SuperMarket.domain.finance;

import com.SuperMarket.SuperMarket.domain.product.Product;

import java.util.List;
import java.util.Objects;

public class TotalLineItem {

    private Integer totalQuantityProducts;
    private Double totalDiscount;
    private Double totalTaxes;
    private Double totalToPay;
    private Double totalAccumulatedPoints;
    private List<InvoiceLineItem> lineItems;
    private Boolean isEmployee;


    public TotalLineItem(List<InvoiceLineItem> lineItems, Boolean isEmployee) {
        this.lineItems = lineItems;
        this.isEmployee = isEmployee;
        this.totalQuantityProducts = calculateTotalQuantityProducts();
        this.totalTaxes = calculateTotalTaxes();
        this.totalToPay = calculateTotalToPay();
        this.totalAccumulatedPoints = calculateTotalAccumulatedPoints();
    }

    private Double calculateTotalAccumulatedPoints() {
        Double reduce = lineItems.stream().map(InvoiceLineItem::getPoints).reduce(0D, Double::sum);
        return reduce;
    }

    private Double calculateTotalToPay() {
        Double reduce = lineItems.stream().map(InvoiceLineItem::getSubtotal).reduce(0D, Double::sum);
        if (isEmployee) {
            return reduce * (1 - 0.05);
        }
        return reduce;
    }

    private Double calculateTotalTaxes() {
        Double reduce = lineItems.stream().map(InvoiceLineItem::getTaxes).reduce(0D, Double::sum);
        if (isEmployee) {
            return reduce * (1 - 0.05);
        }
        return reduce;
    }

    private Integer calculateTotalQuantityProducts() {
        Integer reduce = lineItems.stream().map(InvoiceLineItem::getQuantity).reduce(0, Integer::sum);
        return reduce;
    }

    public Integer getTotalQuantityProducts() {
        return totalQuantityProducts;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public Double getTotalTaxes() {
        return totalTaxes;
    }


    public Double getTotalToPay() {
        return totalToPay;
    }

    public Double getTotalAccumulatedPoints() {
        return totalAccumulatedPoints;
    }

    public List<InvoiceLineItem> getLineItems() {
        return lineItems;
    }

    public Boolean getEmployee() {
        return isEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TotalLineItem that)) return false;
        return Objects.equals(totalQuantityProducts, that.totalQuantityProducts)
                && Objects.equals(totalDiscount, that.totalDiscount) && Objects.equals(totalTaxes, that.totalTaxes)
                && Objects.equals(totalToPay, that.totalToPay)
                && Objects.equals(totalAccumulatedPoints, that.totalAccumulatedPoints)
                && Objects.equals(lineItems, that.lineItems) && Objects.equals(isEmployee, that.isEmployee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalQuantityProducts, totalDiscount, totalTaxes, totalToPay, totalAccumulatedPoints,
                lineItems, isEmployee);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TotalLineItem{");
        sb.append("totalQuantityProducts=").append(totalQuantityProducts);
        sb.append(", totalDiscount=").append(totalDiscount);
        sb.append(", totalTaxes=").append(totalTaxes);
        sb.append(", totalToPay=").append(totalToPay);
        sb.append(", totalAccumulatedPoints=").append(totalAccumulatedPoints);
        sb.append(", lineItems=").append(lineItems);
        sb.append(", isEmployee=").append(isEmployee);
        sb.append('}');
        return sb.toString();
    }
}
