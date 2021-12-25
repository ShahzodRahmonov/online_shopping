package com.company.dto.product;

import com.company.entity.Category;
import lombok.Data;

@Data
public class ProductCreateDTO {

    private String name;
    private Long categoryId;
    private String description;
    private Integer count;
    private Double price;

}
