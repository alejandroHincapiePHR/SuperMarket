package com.SuperMarket.SuperMarket.configuration;

import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.adapter.BillMySQLAdapter;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.adapter.CustomerMySQLAdapter;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.adapter.EmployeeMySQLAdapter;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.adapter.ProductMySQLAdapter;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.administration.Interfaces.CustomerMapper;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.administration.Interfaces.EmployeeMapper;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.administration.implementations.CustomerMapperImp;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.administration.implementations.EmployeeMapperImp;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.administration.implementations.PersonMapperImp;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.bill.implementations.BillMapperImp;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.bill.implementations.InvoiceLineItemMapperImp;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.bill.implementations.TotalLineItemMapperImp;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.bill.interfaces.BillMapper;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.bill.interfaces.InvoiceLineItemMapper;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.bill.interfaces.TotalLineItemMapper;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.products.ProductMapper;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.mappers.products.ProductMapperImp;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.repository.administration.CustomerMySQLRepository;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.repository.administration.EmployeeMySQLRepository;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.repository.bill.BillMySQLRepository;
import com.SuperMarket.SuperMarket.adapters.out.dbs.sql.mysql.springData.repository.product.ProductMySQLRepository;
import com.SuperMarket.SuperMarket.application.ports.admin.customer.out.CustomerByIdPort;
import com.SuperMarket.SuperMarket.application.ports.admin.employe.out.EmployeeByIDPort;
import com.SuperMarket.SuperMarket.application.ports.bill.out.BillCreatedPort;
import com.SuperMarket.SuperMarket.application.ports.bill.out.GetBillByIDPort;
import com.SuperMarket.SuperMarket.application.ports.product.out.GetProductBySkuPort;
import com.SuperMarket.SuperMarket.application.ports.product.out.ProductCreatedPort;
import com.SuperMarket.SuperMarket.application.service.BillService;
import com.SuperMarket.SuperMarket.application.service.CustomerService;
import com.SuperMarket.SuperMarket.application.service.EmployeeService;
import com.SuperMarket.SuperMarket.application.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("MySQL")
public class APIMySQLConfig {

    //Mappers
    @Bean
    ProductMapper productMapper() {
        return new ProductMapperImp();
    }

    @Bean
    CustomerMapperImp customerMapper() {
        return new CustomerMapperImp();
    }

    @Bean
    EmployeeMapperImp employeeMapper() {
        return new EmployeeMapperImp();
    }

    @Bean
    PersonMapperImp personMapper() {
        return new PersonMapperImp();
    }

    @Bean
    InvoiceLineItemMapperImp invoiceLineItemMapperImp(ProductMapper productMapper) {
        return new InvoiceLineItemMapperImp(productMapper);
    }

    @Bean
    TotalLineItemMapperImp totalLineItemMapperImp(InvoiceLineItemMapper invoiceLineItemMapper) {
        return new TotalLineItemMapperImp(invoiceLineItemMapper);
    }

    @Bean
    BillMapperImp billMapper(CustomerMapperImp customerMapperImp, EmployeeMapperImp employeeMapperImp,
                             InvoiceLineItemMapper invoiceLineItemMapper, TotalLineItemMapper totalLineItemMapper) {
        return new BillMapperImp(customerMapperImp, employeeMapperImp, invoiceLineItemMapper, totalLineItemMapper);
    }


    //adapters
    @Bean
    BillMySQLAdapter billMySQLAdapter(BillMapper billMapper, BillMySQLRepository billMySQLRepository) {
        return new BillMySQLAdapter(billMapper, billMySQLRepository);
    }

    @Bean
    CustomerMySQLAdapter customerMySQLAdapter(CustomerMySQLRepository customerMySQLRepository, CustomerMapper customerMapper) {
        return new CustomerMySQLAdapter(customerMySQLRepository, customerMapper);
    }

    @Bean
    EmployeeMySQLAdapter employeeMySQLAdapter(EmployeeMySQLRepository employeeMySQLRepository, EmployeeMapper employeeMapper) {
        return new EmployeeMySQLAdapter(employeeMySQLRepository, employeeMapper);
    }

    @Bean
    ProductMySQLAdapter productMySQLAdapter(ProductMySQLRepository productMySQLRepository, ProductMapper productMapper) {
        return new ProductMySQLAdapter(productMySQLRepository, productMapper);
    }


    //Services
    @Bean
    BillService billService(BillCreatedPort billCreatedPort,GetBillByIDPort getBillByIDPort) {
        return new BillService(billCreatedPort, getBillByIDPort);
    }

    @Bean
    CustomerService customerService(CustomerByIdPort customerByIdPort) {
        return new CustomerService(customerByIdPort);
    }

    @Bean
    EmployeeService employeeService(EmployeeByIDPort employeeByIDPort) {
        return new EmployeeService(employeeByIDPort);
    }

    @Bean
    ProductService productService(ProductCreatedPort productCreatedPort,
                                  GetProductBySkuPort productConsultPort) {
        return new ProductService(productCreatedPort, productConsultPort);
    }


}
