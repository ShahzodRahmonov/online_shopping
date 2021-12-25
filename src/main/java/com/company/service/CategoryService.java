package com.company.service;

import com.company.converter.CategoryConverter;
import com.company.dto.category.CategoryCreateDTO;
import com.company.dto.category.CategoryDTO;
import com.company.entity.Category;
import com.company.entity.Product;
import com.company.exceptions.CategoryNotFoundException;
import com.company.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductService productService;

    public Category add(CategoryCreateDTO dto){
        Category category = new Category();
        category.setName(dto.getName());
        return categoryRepository.save(category);
    }


    public List<CategoryDTO> getList(){
        return categoryRepository.findAll().stream().map(CategoryConverter::toDTO).collect(Collectors.toList());
    }


    public CategoryDTO getById(Long id){
        Category category = this.getCategory(id);
        return CategoryConverter.toDTO(category);
    }


    public CategoryDTO getCategoryProductId(Long id){
        Product product = productService.getProduct(id);
        return CategoryConverter.toDTO(product.getCategory());
    }




    public Category getCategory(Long id){
        Optional<Category> optional = categoryRepository.findById(id);
        if (!optional.isPresent()) {
            throw new CategoryNotFoundException("Category not found!!!");
        }
        return optional.get();
    }


}
