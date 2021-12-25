package com.company.controller;

import com.company.dto.order.OrderAddDTO;
import com.company.dto.order.OrderCreateDTO;
import com.company.service.DetailService;
import com.company.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/order")
@Api(tags = "Order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private DetailService detailService;

    @ApiOperation("Add order, DateTimeFormatter : dd.MM.yyyy")
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody OrderAddDTO dto){
        log.info("create order: {} " + dto);
        return ResponseEntity.ok(orderService.add(dto));
    }


    @ApiOperation("Create order, make order create invoice while creating new order")
    @PostMapping()
    public ResponseEntity<?> add2(@RequestBody OrderCreateDTO dto){
        log.info("create new order: {} " + dto);
        return ResponseEntity.ok(orderService.add2(dto));
    }


    @ApiOperation("Get order details by id")
    @GetMapping("/details")
    public ResponseEntity<?> getOrderDetail(@RequestParam Long orderId){
        log.info("get order details by id: id = "+orderId);
        return ResponseEntity.ok(orderService.getOrderDetail(orderId));
    }


    @ApiOperation("customers_last_orders")
    @GetMapping("/customersLastOrders")
    public ResponseEntity<?> customersLastOrders(){
        log.info("customers_last_orders");
        return ResponseEntity.ok(orderService.customersLastOrders());
    }


    @ApiOperation("orders_without_details")
    @GetMapping("/ordersWithoutDetails")
    public ResponseEntity<?> ordersWithoutDetails(){
        log.info("orders_without_details");
        return ResponseEntity.ok(orderService.ordersWithoutDetails());
    }


    @ApiOperation("high_demand_products")
    @GetMapping("/highDemandProducts")
    public ResponseEntity<?> highDemandProducts(){
        log.info("high_demand_products");
        return ResponseEntity.ok(detailService.highDemandProducts());
    }


    @ApiOperation("orders_without_invoices")
    @GetMapping("/ordersWithoutInvoices")
    public ResponseEntity<?> ordersWithoutInvoices(){
        log.info("orders_without_invoices");
        return ResponseEntity.ok(orderService.ordersWithoutInvoices());
    }
}
