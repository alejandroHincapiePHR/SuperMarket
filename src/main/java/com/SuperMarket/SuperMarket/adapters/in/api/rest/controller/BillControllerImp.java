package com.SuperMarket.SuperMarket.adapters.in.api.rest.controller;

import com.SuperMarket.SuperMarket.application.exceptions.CustomerNotFoundException;
import com.SuperMarket.SuperMarket.application.exceptions.EmployeeNotFoundException;
import com.SuperMarket.SuperMarket.application.exceptions.ProductNotFoundException;
import com.SuperMarket.SuperMarket.adapters.in.api.rest.ErorHandling.SkuListObjectNullException;
import com.SuperMarket.SuperMarket.adapters.in.api.rest.commons.CustomResponse;
import com.SuperMarket.SuperMarket.adapters.in.api.rest.commons.SkuListObject;
import com.SuperMarket.SuperMarket.application.service.BillService;
import com.SuperMarket.SuperMarket.application.service.CustomerService;
import com.SuperMarket.SuperMarket.application.service.EmployeeService;
import com.SuperMarket.SuperMarket.application.service.ProductService;
import com.SuperMarket.SuperMarket.domain.admin.Customer;
import com.SuperMarket.SuperMarket.domain.admin.Employee;
import com.SuperMarket.SuperMarket.domain.product.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

import static com.SuperMarket.SuperMarket.adapters.in.api.rest.constant.ApiGlobalConstant.*;
import static com.SuperMarket.SuperMarket.adapters.in.api.rest.constant.ApiMethodsConstants.*;
import static com.SuperMarket.SuperMarket.adapters.in.api.rest.constant.MessageConstants.*;

@RestController
@RequestMapping(API_BILL)
public class BillControllerImp {

    private BillService billService;
    private CustomerService customerService;
    private EmployeeService employeeService;
    private ProductService productService;

       public BillControllerImp(BillService billService, CustomerService customerService, EmployeeService employeeService, ProductService productService) {
        this.billService = billService;
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.productService = productService;
    }

    /**
     * Method that creates a bill in SuperMarket Java API.
     *
     * @author Alejandro Hincapie
     * @since 06/10/2023
     *
     * @param idCustomer
     * @param idEmployee
     * @param skuListObject
     * @return ResponseEntity with a Response<BillId> object and the HTTP status
     *
     */
    @Operation(
            summary = "Crear una factura",
            description = "Crea una factura en la API de SuperMarket."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "La factura se creó exitosamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ResponseEntity.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Solicitud incorrecta"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "No autorizado"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Prohibido"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No encontrado"
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Conflicto"
            ),
            @ApiResponse(
                    responseCode = "429",
                    description = "Demasiadas solicitudes"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error del servidor"
            )
    })
    @PostMapping("/{idCustomer}/{idEmployee}")
    public ResponseEntity<CustomResponse> createBill (
            @Parameter(description = "ID del cliente", required = true)
            @PathVariable(name = "idCustomer") Integer idCustomer,
            @Parameter(description = "ID del empleado", required = true)
            @PathVariable(name = "idEmployee") Integer idEmployee,
            @Parameter(description = "Lista de productos SKU", required = true)
            @RequestBody SkuListObject skuListObject) throws ProductNotFoundException, EmployeeNotFoundException,
            CustomerNotFoundException, SkuListObjectNullException {
        if(skuListObject.getSkuList() == null){
            throw new SkuListObjectNullException();
        }
        Customer customer = customerService.customerById(idCustomer.longValue());
        Employee employee = employeeService.employeeById(idEmployee.longValue());
        List<Product> products = productService.skuListToProductList(skuListObject.getSkuList());
        Long billId =  billService.billCreationUseCase(employee,customer, products);
        CustomResponse customResponse = new CustomResponse();
        customResponse.setApi(API_BILL);
        customResponse.setMethod(CREATE_BILL);
        customResponse.setCode("201");
        customResponse.setMessage(MSG_RESPONSE_OK);
        customResponse.setResponse(billId);
        return ResponseEntity.status(HttpStatus.CREATED).body(customResponse);
    }
}
