package com.company.dto.order;

import com.company.enums.OrderStatus;
import lombok.Data;

@Data
public class OrderResponseDTO {

    private OrderStatus orderStatus;
    private Long InvoiceId;

}
