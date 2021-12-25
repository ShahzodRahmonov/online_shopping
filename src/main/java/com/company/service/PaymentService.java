package com.company.service;

import com.company.converter.PaymentConverter;
import com.company.dto.payment.*;
import com.company.entity.Invoice;
import com.company.entity.Payment;
import com.company.enums.OrderStatus;
import com.company.enums.PaymentStatus;
import com.company.exceptions.PaymentNotFoundException;
import com.company.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private InvoiceService invoiceService;

    public PaymentDTO add(AddPaymentDTO dto){
        Invoice invoice = invoiceService.getInvoice(dto.getInvoiceId());
        Payment payment = new Payment();
        payment.setInvoice(invoice);
        payment.setAmount(dto.getAmount());
        payment.setPaymentStatus(PaymentStatus.SUCCESS);
        return PaymentConverter.toDTO(paymentRepository.save(payment));
    }

    public PaymentResponseDTO create(PaymentCreateDTO dto){
        Invoice invoice = invoiceService.getInvoice(dto.getInvoiceId());
        Payment payment = new Payment();
        payment.setAmount(invoice.getAmound());
        payment.setInvoice(invoice);
        if (invoice.getOrderStatus().equals(OrderStatus.FAILED)||invoice.getDue().isBefore(LocalDate.now())){
            payment.setPaymentStatus(PaymentStatus.FAILED);
        }
        else {
            payment.setPaymentStatus(PaymentStatus.SUCCESS);
        }
        paymentRepository.save(payment);
        PaymentResponseDTO responseDTO = new PaymentResponseDTO();
        responseDTO.setPaymentStatus(payment.getPaymentStatus());
        responseDTO.setPaymentDTO(PaymentConverter.toDTO(payment));
        return responseDTO;
    }


    public PaymentDTO getById(Long id){
        Optional<Payment> optional = paymentRepository.findById(id);
        if (!optional.isPresent()) {
            throw new PaymentNotFoundException("Payment not found!!!");
        }
        return PaymentConverter.toDTO(optional.get());
    }


    public List<OverpaidInvoices> overpaidInvoices(){
        return paymentRepository.overpaidInvoices();
    }
}
