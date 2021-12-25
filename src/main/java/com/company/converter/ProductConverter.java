package com.company.converter;

import com.company.dto.product.ProductDTO;
import com.company.entity.Product;

import java.util.UUID;

public class ProductConverter {

    public static ProductDTO toDTO(Product product){
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setCategoryId(product.getCategory().getId());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setPhoto(UUID.randomUUID().toString());
        return dto;
    }
}
