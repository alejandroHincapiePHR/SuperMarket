package com.SuperMarket.SuperMarket.adapters.in.api.rest.ErorHandling;

import com.SuperMarket.SuperMarket.adapters.in.api.rest.commons.CustomResponse;
import com.SuperMarket.SuperMarket.application.exceptions.CustomerNotFoundException;
import com.SuperMarket.SuperMarket.application.exceptions.EmployeeNotFoundException;
import com.SuperMarket.SuperMarket.application.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static com.SuperMarket.SuperMarket.adapters.in.api.rest.constant.ApiGlobalConstant.API_BILL;
import static com.SuperMarket.SuperMarket.adapters.in.api.rest.constant.ApiMethodsConstants.CREATE_BILL;
import static com.SuperMarket.SuperMarket.adapters.in.api.rest.constant.MessageConstants.*;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<CustomResponse> methodArgumentTypeMismatchException (MethodArgumentTypeMismatchException exc){
        CustomResponse customResponse = new CustomResponse();
        customResponse.setApi(API_BILL);
        customResponse.setMethod(CREATE_BILL);
        customResponse.setCode("400");
        customResponse.setMessage(MSG_RESPONSE_BAD_REQUEST);
        customResponse.setResponse("Se requiere ID de tipo integer para ID empleado e ID cliente");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customResponse);

    }
    @ExceptionHandler
    public ResponseEntity<CustomResponse> customerNotFoundException (CustomerNotFoundException exc){
        CustomResponse customResponse = new CustomResponse();
        customResponse.setApi(API_BILL);
        customResponse.setMethod(CREATE_BILL);
        customResponse.setCode("404");
        customResponse.setMessage(MSG_RESPONSE_NOT_FOUND);
        customResponse.setResponse("Cliente no encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customResponse);

    }
    @ExceptionHandler
    public ResponseEntity<CustomResponse> employeeNotFoundException (EmployeeNotFoundException exc){
        CustomResponse customResponse = new CustomResponse();
        customResponse.setApi(API_BILL);
        customResponse.setMethod(CREATE_BILL);
        customResponse.setCode("404");
        customResponse.setMessage("Empleado no encontrado");
        customResponse.setResponse("null");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customResponse);

    }
    @ExceptionHandler
    public ResponseEntity<CustomResponse> skuListObjectNullException (SkuListObjectNullException exc){
        CustomResponse customResponse = new CustomResponse();
        customResponse.setApi(API_BILL);
        customResponse.setMethod(CREATE_BILL);
        customResponse.setCode("400");
        customResponse.setMessage(MSG_RESPONSE_BAD_REQUEST);
        customResponse.setResponse("La lista de carrito de compras de productos esta vacia");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customResponse);

    }
    @ExceptionHandler
    public ResponseEntity<CustomResponse> httpMessageNotReadableException (HttpMessageNotReadableException exc){
        CustomResponse customResponse = new CustomResponse();
        customResponse.setApi(API_BILL);
        customResponse.setMethod(CREATE_BILL);
        customResponse.setCode("400");
        customResponse.setMessage(MSG_RESPONSE_BAD_REQUEST);
        customResponse.setResponse("Se requiere un cuerpo JSON (Lista de productos 'skuList') en la solicitud");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customResponse);

    }

    @ExceptionHandler
    public ResponseEntity<CustomResponse> productNotFoundException (ProductNotFoundException exc){
        CustomResponse customResponse = new CustomResponse();
        customResponse.setApi(API_BILL);
        customResponse.setMethod(CREATE_BILL);
        customResponse.setCode("404");
        customResponse.setMessage(MSG_RESPONSE_NOT_FOUND);
        customResponse.setResponse("Producto (SKU) no encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customResponse);

    }




}
