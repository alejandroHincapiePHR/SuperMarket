package com.SuperMarket.SuperMarket.domain.finance;
import com.SuperMarket.SuperMarket.domain.exception.DomainRuntimeException;
import com.SuperMarket.SuperMarket.domain.exception.InvalidResultException;
import com.SuperMarket.SuperMarket.domain.finance.util.ConfigReader;

import java.util.List;
import java.util.Objects;

public final class TotalLineItem {

    private static final ConfigReader configReader = new ConfigReader();
    private Double employeeDiscount;
    private Integer totalQuantityProducts;
    private Double totalDiscount;
    private Double totalTaxes;
    private Double totalToPay;
    private Double totalAccumulatedPoints;
    private List<InvoiceLineItem> lineItems;
    private Boolean isEmployee;


    public TotalLineItem(List<InvoiceLineItem> lineItems, Boolean isEmployee) {
        validArgumentCheck(lineItems, isEmployee);
        this.lineItems = lineItems;
        this.isEmployee = isEmployee;
        this.employeeDiscount = getEmployeeDiscountFromFile();
        this.totalQuantityProducts = calculateTotalQuantityProducts();
        this.totalTaxes = calculateTotalTaxes();
        this.totalToPay = calculateTotalToPay();
        this.totalAccumulatedPoints = calculateTotalAccumulatedPoints();
        this.totalDiscount = calculateTotalDiscount();
    }

    private void validArgumentCheck(List<InvoiceLineItem> lineItems, Boolean isEmployee) {
        if (lineItems==null || isEmployee == null){
            throw new DomainRuntimeException("Total can not be calculated with current arguments");
        }
    }

    private void checkNegative(double result) throws InvalidResultException {
        if (result <=0){
            throw new InvalidResultException("Value should not be negative");
        }
    }

    private Double getEmployeeDiscountFromFile() {
        String parameter = "employeeDiscount";
        configReader.loadConfig("config.properties", parameter);
        double employeeDiscount = configReader.getParameterValue();
        checkNegative(employeeDiscount);
        checkPCT(employeeDiscount);
        return employeeDiscount;

    }

    private void checkPCT(double employeeDiscount) {
        if(employeeDiscount>=1){
            throw new DomainRuntimeException("Employee discount can not be greater than 1 (100%)");
        }
    }

    private Double calculateTotalDiscount() {
        Double reduce = lineItems.stream().map(InvoiceLineItem::getDiscount).reduce(0D, Double::sum);
        checkNegative(reduce);
        if (isEmployee) {
            return reduce + (totalToPay * employeeDiscount);
        }
        return reduce;
    }

    private Double calculateTotalAccumulatedPoints() {
        Double reduce = lineItems.stream().map(InvoiceLineItem::getPoints).reduce(0D, Double::sum);
        checkNegative(reduce);
        return reduce;
    }

    private Double calculateTotalToPay() {
        Double reduce = lineItems.stream().map(InvoiceLineItem::getSubtotal).reduce(0D, Double::sum);
        checkNegative(reduce);
        if (isEmployee) {
            return reduce * (1 - employeeDiscount);
        }
        return reduce;
    }

    private Double calculateTotalTaxes() {
        Double reduce = lineItems.stream().map(InvoiceLineItem::getTaxes).reduce(0D, Double::sum);
        checkNegative(reduce);
        if (isEmployee) {
            return reduce * (1 - employeeDiscount);
        }
        return reduce;
    }

    private Integer calculateTotalQuantityProducts() {
        Integer reduce = lineItems.stream().map(InvoiceLineItem::getQuantity).reduce(0, Integer::sum);
        checkNegative(reduce);
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
