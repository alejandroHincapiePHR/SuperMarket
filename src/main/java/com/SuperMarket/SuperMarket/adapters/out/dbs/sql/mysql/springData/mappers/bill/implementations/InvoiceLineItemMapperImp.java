package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.bill.implementations;

import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.bill.InvoiceLineItemMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.product.ProductMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.bill.interfaces.InvoiceLineItemMapper;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.products.ProductMapper;
import com.SuperMarket.SuperMarket.domain.finance.InvoiceLineItem;
import com.SuperMarket.SuperMarket.domain.product.Product;

public class InvoiceLineItemMapperImp implements InvoiceLineItemMapper {

    private ProductMapper productMapper;


    public InvoiceLineItemMapperImp(final ProductMapper productMapper) {
        this.productMapper = productMapper;

    }

    @Override
    public InvoiceLineItem toDomain(InvoiceLineItemMySQLEntity i) {
        Product product = productMapper.toDomain(i.getProduct());
        InvoiceLineItem invoiceLineItem = new InvoiceLineItem(product, 1);
        return invoiceLineItem;
    }
    @Override
    public InvoiceLineItemMySQLEntity toEntity(InvoiceLineItem i) {
        ProductMySQLEntity product = productMapper.toEntity(i.getProduct());


        InvoiceLineItemMySQLEntity invoiceLineItemMySQLEntity = new InvoiceLineItemMySQLEntity(
                null, product, i.getQuantity(), i.getTaxes(), i.getDiscount(),
                i.getSubtotal(), i.getPoints(), i.getTaxesPCT(), i.getPointsPCT(),
                i.getDiscountPCT());
        return invoiceLineItemMySQLEntity;
    }
}
