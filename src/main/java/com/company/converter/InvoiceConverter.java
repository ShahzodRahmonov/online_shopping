package com.company.converter;

import com.company.dto.invoice.InvoiceDTO;
import com.company.entity.Invoice;

public class InvoiceConverter {

    public static InvoiceDTO toDTO(Invoice invoice){
        InvoiceDTO dto = new InvoiceDTO();
        dto.setId(invoice.getId());
        dto.setOrderId(invoice.getOrder().getId());
        dto.setAmound(invoice.getAmound());
        dto.setIssued(invoice.getIssued().toString());
        dto.setDue(invoice.getDue().toString());
        dto.setOrderStatus(invoice.getOrderStatus());
        return dto;
    }

}
