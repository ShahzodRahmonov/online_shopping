package com.company.converter;

import com.company.dto.order.OrderAddDTO;
import com.company.dto.order.OrderDTO;
import com.company.entity.Order;
import org.aspectj.weaver.ast.Or;

public class OrderConverter {

    public static OrderDTO toDTO(Order order){
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setCustomerId(order.getCustomer().getId());
        dto.setDate(order.getDate().toString());
        dto.setStatus(order.getStatus());
        return dto;
    }


}
