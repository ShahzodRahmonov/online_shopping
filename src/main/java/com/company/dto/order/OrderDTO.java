package com.company.dto.order;

import com.company.entity.Customer;
import com.company.enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class OrderDTO {
    private Long id;
    private String date;
    private Long customerId;
    private OrderStatus status;
}
