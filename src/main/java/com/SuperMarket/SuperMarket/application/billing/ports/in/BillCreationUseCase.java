package com.SuperMarket.SuperMarket.application.billing.ports.in;

import com.SuperMarket.SuperMarket.domain.finance.Bill;

@FunctionalInterface
public interface BillCreationUseCase {

    Bill billCreation();


}
