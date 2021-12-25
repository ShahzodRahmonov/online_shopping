package com.company.converter;

import com.company.dto.customer.CustomerDTO;
import com.company.entity.Customer;

public class CustomerConverter {

    public static CustomerDTO toDTO(Customer customer){
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setPhone(customer.getPhone());
        dto.setAddress(customer.getAddress());
        dto.setCountry(customer.getCountry());
        return dto;
    }
}
