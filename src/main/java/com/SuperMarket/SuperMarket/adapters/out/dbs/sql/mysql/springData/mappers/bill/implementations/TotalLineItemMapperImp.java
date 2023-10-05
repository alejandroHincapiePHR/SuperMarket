package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.bill.implementations;

import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.bill.InvoiceLineItemMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.bill.TotalLineItemMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.bill.interfaces.InvoiceLineItemMapper;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.bill.interfaces.TotalLineItemMapper;
import com.SuperMarket.SuperMarket.domain.finance.InvoiceLineItem;
import com.SuperMarket.SuperMarket.domain.finance.TotalLineItem;


import java.util.List;


public class TotalLineItemMapperImp implements TotalLineItemMapper {

    private InvoiceLineItemMapper invoiceLineItemMapper;


    public TotalLineItemMapperImp(final InvoiceLineItemMapper invoiceLineItemMapper) {
        this.invoiceLineItemMapper = invoiceLineItemMapper;
    }

    @Override
    public TotalLineItem toDomain(TotalLineItemMySQLEntity t) {
        /*List<InvoiceLineItem> invoiceLineItemList = t.getInvoiceLineItemMySQLEntitiesList().stream()
                .map(invoiceLineItemMapper::toDomain).toList();
        TotalLineItem totalLineItem = new TotalLineItem(invoiceLineItemList, Boolean.TRUE);
        return totalLineItem;
        */
        return null;
    }

    @Override
    public TotalLineItemMySQLEntity toEntity(TotalLineItem t) {
        List<InvoiceLineItemMySQLEntity> invoiceLineItemMySQLEntityList = t.getLineItems().stream()
                .map(invoiceLineItemMapper::toEntity).toList();

        TotalLineItemMySQLEntity totalLineItemMySQLEntity = new TotalLineItemMySQLEntity(null,
                0D,t.getTotalQuantityProducts(),t.getTotalDiscount(), t.getTotalTaxes(),
                t.getTotalToPay(), t.getTotalAccumulatedPoints());

        return totalLineItemMySQLEntity;
    }
}
