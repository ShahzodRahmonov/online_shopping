package com.company.dto.detail;

import lombok.Data;

@Data
public class DetailDTO {

    private Long id;
    private Long orderId;
    private Long productId;
    private Integer quantity;
}
