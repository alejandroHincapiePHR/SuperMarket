package com.SuperMarket.SuperMarket.adapters.in.api.rest.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
    private List<String> SKUs;

}
