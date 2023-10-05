package com.SuperMarket.SuperMarket.adapters.in.api.rest.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"api","method","code","message","dateTime","response"})
public class CustomResponse {
    private String api;
    private String method;
    private String code;
    private String message;
    private String dateTime;
    private Object response;


    public String getDateTime() {
        String pattern = "dd/MM/yyyy hh:mm:ss a";
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern(pattern));
    }
}
