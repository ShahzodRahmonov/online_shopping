package com.company.converter;

import com.company.dto.category.CategoryDTO;
import com.company.entity.Category;

public class CategoryConverter {

    public static CategoryDTO toDTO(Category category){
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }
}
