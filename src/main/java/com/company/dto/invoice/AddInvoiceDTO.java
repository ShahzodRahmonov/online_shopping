package com.company.dto.invoice;

import lombok.Data;

@Data
public class AddInvoiceDTO {
    private Long orderId;
    private Double amound;
    private String issued;
    private String due;
}
