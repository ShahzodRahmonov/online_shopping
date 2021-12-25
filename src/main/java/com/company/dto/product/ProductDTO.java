package com.company.dto.product;

import lombok.Data;
@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Long categoryId;
    private String description;
    private Double price;
    private String photo;
}
