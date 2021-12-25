package com.company.dto.customer;

import lombok.Data;

@Data
public class CustomerDTO {

    private Long id;
    private String name;
    private String country;
    private String address;
    private String phone;

}
