package com.company.dto.detail;

import lombok.Data;

@Data
public class AddDetailDTO {
    private Long orderId;
    private Long productId;
    private Integer quantity;
}
