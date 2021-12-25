package com.company.service;

import com.company.converter.InvoiceConverter;
import com.company.dto.invoice.AddInvoiceDTO;
import com.company.dto.invoice.InvoiceDTO;
import com.company.dto.invoice.WrongDateInvoices;
import com.company.entity.Invoice;
import com.company.entity.Order;
import com.company.entity.Product;
import com.company.exceptions.InvoiceNotFoundException;
import com.company.exceptions.OrderNotFoundException;
import com.company.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private OrderService orderService;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


    public InvoiceDTO add(AddInvoiceDTO dto){
        Order order = orderService.getOrder(dto.getOrderId());
        Optional<Invoice> optional = invoiceRepository.findByOrderId(dto.getOrderId());
        if (optional.isPresent()) {
            throw new OrderNotFoundException("An invoice for this order has been created before!!!");
        }
        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setAmound(dto.getAmound());
        invoice.setOrderStatus(order.getStatus());
        invoice.setIssued(LocalDate.parse(dto.getIssued(),formatter));
        invoice.setDue(LocalDate.parse(dto.getDue(),formatter));
        return InvoiceConverter.toDTO(invoiceRepository.save(invoice));
    }

    public Invoice add2(Integer quantity, Order order, Product product){
        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setAmound(quantity.doubleValue());
        invoice.setIssued(LocalDate.now());
        invoice.setDue(LocalDate.now().plusDays(1));
        invoice.setOrderStatus(order.getStatus());
        return invoiceRepository.save(invoice);
    }


    public Invoice getInvoice(Long id){
        Optional<Invoice> optional = invoiceRepository.findById(id);
        if (!optional.isPresent()) {
            throw new InvoiceNotFoundException("Invoice not found!!!");
        }
        return optional.get();
    }


    public List<InvoiceDTO> expiredInvoices(){
        return invoiceRepository.expiredInvoices().stream().map(InvoiceConverter::toDTO).collect(Collectors.toList());
    }


    public List<WrongDateInvoices> wrongDateInvoices(){
        return invoiceRepository.wrongDateInvoices();
    }
}


