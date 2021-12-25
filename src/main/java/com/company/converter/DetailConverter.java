package com.company.converter;

import com.company.dto.detail.DetailDTO;
import com.company.dto.order.GetOrderDetailDTO;
import com.company.entity.Detail;

public class DetailConverter {

    public static GetOrderDetailDTO toDTO(Detail detail){
        GetOrderDetailDTO dto = new GetOrderDetailDTO();
        dto.setId(detail.getId());
        dto.setOrderId(detail.getOrder().getId());
        dto.setProductId(detail.getProduct().getId());
        dto.setQuantity(detail.getQuantity());
        dto.setProductName(detail.getProduct().getName());
        return dto;
    }

    public static DetailDTO toDetailDTO(Detail detail){
        DetailDTO dto = new DetailDTO();
        dto.setId(detail.getId());
        dto.setOrderId(detail.getOrder().getId());
        dto.setProductId(detail.getProduct().getId());
        dto.setQuantity(detail.getQuantity());
        return dto;
    }
}
