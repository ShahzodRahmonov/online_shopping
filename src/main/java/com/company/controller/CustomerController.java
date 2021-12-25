package com.company.controller;

import com.company.dto.customer.CustomerCreateDTO;
import com.company.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/customer")
@Api(tags = "Customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @ApiOperation("add customer")
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CustomerCreateDTO dto){
        log.info("add customer: {} " + dto);
        return ResponseEntity.ok(customerService.add(dto));
    }

    @ApiOperation("customers_without_orders")
    @GetMapping("/customersWithoutOrders")
    public ResponseEntity<?> customersWithoutOrders(){
        log.info("customers_without_orders");
        return ResponseEntity.ok(customerService.customersWithoutOrders());
    }

    @ApiOperation("number_of_products_in_year")
    @GetMapping("/numberOfProductsInYear")
    public ResponseEntity<?> numberOfProductsInYear(){
        log.info("number_of_products_in_year");
        return ResponseEntity.ok(customerService.numberOfProductsInYear());
    }
}
