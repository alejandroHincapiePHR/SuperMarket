package com.SuperMarket.SuperMarket.adapters.in.api.rest.controller;

import com.SuperMarket.SuperMarket.adapters.in.api.rest.commons.AddProductRequest;
import com.SuperMarket.SuperMarket.application.service.BillService;
import com.SuperMarket.SuperMarket.application.service.CustomerService;
import com.SuperMarket.SuperMarket.application.service.EmployeeService;
import com.SuperMarket.SuperMarket.application.service.ProductService;
import com.SuperMarket.SuperMarket.domain.admin.Customer;
import com.SuperMarket.SuperMarket.domain.admin.Employee;
import com.SuperMarket.SuperMarket.domain.finance.Bill;
import com.SuperMarket.SuperMarket.domain.finance.InvoiceLineItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static com.SuperMarket.SuperMarket.adapters.in.api.rest.constant.ApiGlobalConstant.API_BILL;

@RestController
@RequestMapping(API_BILL)
public class BillController {

    private BillService billService;
    private CustomerService customerService;
    private EmployeeService employeeService;
    private ProductService productService;

       public BillController(BillService billService, CustomerService customerService, EmployeeService employeeService, ProductService productService) {
        this.billService = billService;
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.productService = productService;
    }


    @PostMapping("/{idCustomer}/{idEmployee}")
    public ResponseEntity<String> createBill(@PathVariable(name = "idCustomer") Integer idCustomer,
                                                     @PathVariable(name = "idEmployee") Integer idEmployee,
                                            @RequestBody AddProductRequest addProductRequest) {
        Customer customer = customerService.customerById(idCustomer.longValue());
        Employee employee = employeeService.employeeById(idEmployee.longValue());
        Bill bill = billService.billInitialization(customer, employee);
        addProductRequest.getSKUs().stream().map(x->productService.getProductBySku(x))
                .forEach(x->bill.setLineItem(new InvoiceLineItem(x,1)));
        billService.billConfirmation(bill);
        return ResponseEntity.status(HttpStatus.CREATED).body(bill.toString());
    }



}
