package com.company.converter;

import com.company.dto.payment.PaymentDTO;
import com.company.entity.Payment;

public class PaymentConverter {

    public static PaymentDTO toDTO(Payment payment){
        PaymentDTO dto = new PaymentDTO();
        dto.setId(payment.getId());
        dto.setPaymentStatus(payment.getPaymentStatus());
        dto.setTime(payment.getTime());
        dto.setAmount(payment.getAmount());
        dto.setInvoiceId(payment.getInvoice().getId());
        return dto;
    }

}
