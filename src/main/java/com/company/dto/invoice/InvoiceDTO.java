package com.company.dto.invoice;

import com.company.enums.OrderStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class InvoiceDTO {
    private Long id;
    private Long orderId;
    private Double amound;
    private String issued;
    private String due;
    private OrderStatus orderStatus;
}
