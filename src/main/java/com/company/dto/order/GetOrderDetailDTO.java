package com.company.dto.order;

import com.company.entity.Detail;
import com.company.entity.Order;
import com.company.entity.Product;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class GetOrderDetailDTO {

    private Long id;
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private String productName;

}
