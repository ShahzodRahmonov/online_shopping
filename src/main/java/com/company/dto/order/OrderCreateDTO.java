package com.company.dto.order;

import lombok.Data;

@Data
public class OrderCreateDTO {

    private Long customerId;
    private Long productId;
    private Integer quantity;

}
