package com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.bill.interfaces;

import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.entity.bill.InvoiceLineItemMySQLEntity;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.base.GenericMapper;
import com.SuperMarket.SuperMarket.domain.finance.InvoiceLineItem;

public interface InvoiceLineItemMapper extends GenericMapper<InvoiceLineItem, InvoiceLineItemMySQLEntity> {
}
