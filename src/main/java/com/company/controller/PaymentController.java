package com.company.controller;

import com.company.dto.payment.AddPaymentDTO;
import com.company.dto.payment.PaymentCreateDTO;
import com.company.dto.payment.PaymentDTO;
import com.company.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/payment")
@Api(tags = "Payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @ApiOperation("add payment")
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody AddPaymentDTO dto){
        log.info("add payment: {} " + dto);
        return ResponseEntity.ok(paymentService.add(dto));
    }

    @ApiOperation("make payment")
    @PostMapping()
    public ResponseEntity create(@RequestBody PaymentCreateDTO dto){
        log.info("make payment: {} " + dto);
        return ResponseEntity.ok(paymentService.create(dto));
    }

    @ApiOperation("get payment details by id")
    @GetMapping("/details")
    public ResponseEntity<?> getById(@RequestParam Long id){
        log.info("get payment details by id: id = "+id);
        return ResponseEntity.ok(paymentService.getById(id));
    }

    @ApiOperation("overpaid_invoices")
    @GetMapping("/overpaidInvoices")
    public ResponseEntity<?> overpaidInvoices(){
        log.info("overpaid_invoices");
        return ResponseEntity.ok(paymentService.overpaidInvoices());
    }
}
