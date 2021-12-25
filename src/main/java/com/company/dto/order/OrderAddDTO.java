package com.company.dto.order;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class OrderAddDTO {
    private String date;
    private Long customerId;
}
