package com.company.dto.payment;

import lombok.Data;

@Data
public class AddPaymentDTO {
    private Long invoiceId;
    private Double amount;
}
