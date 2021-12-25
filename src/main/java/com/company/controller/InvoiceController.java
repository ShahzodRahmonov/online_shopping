package com.company.controller;

import com.company.dto.invoice.AddInvoiceDTO;
import com.company.dto.invoice.InvoiceDTO;
import com.company.service.InvoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/invoice")
@Api(tags = "Invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @ApiOperation("add invoice, DateTimeFormatter : dd.MM.yyyy")
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AddInvoiceDTO dto){
        log.info("add new invoice: {} " + dto);
        return ResponseEntity.ok(invoiceService.add(dto));
    }

    @ApiOperation("expired_invoices")
    @GetMapping("/expiredInvoices")
    public ResponseEntity<?> expiredInvoices(){
        log.info("expired_invoices");
        return ResponseEntity.ok(invoiceService.expiredInvoices());
    }

    @ApiOperation("wrong_date_invoices")
    @GetMapping("/wrongDateInvoices")
    public ResponseEntity<?> wrongDateInvoices(){
        log.info("wrong_date_invoices");
        return ResponseEntity.ok(invoiceService.wrongDateInvoices());
    }
}
