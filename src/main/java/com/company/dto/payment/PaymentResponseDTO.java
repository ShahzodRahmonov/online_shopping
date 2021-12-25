package com.company.dto.payment;

import com.company.dto.payment.PaymentDTO;
import com.company.enums.PaymentStatus;
import lombok.Data;

@Data
public class PaymentResponseDTO {

    private PaymentStatus paymentStatus;
    private PaymentDTO paymentDTO;

}
