package com.SuperMarket.SuperMarket.adapters.in.api.rest.initTest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class InitController {
    @GetMapping
    public ResponseEntity<String> init(){
        return ResponseEntity.ok().body("Started Up");

    }
}
