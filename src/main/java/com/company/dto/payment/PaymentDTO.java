package com.company.dto.payment;
import com.company.enums.PaymentStatus;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class PaymentDTO {

    private Long id;
    private LocalDateTime time;
    private Double amount;
    private Long invoiceId;
    private PaymentStatus paymentStatus;

}
