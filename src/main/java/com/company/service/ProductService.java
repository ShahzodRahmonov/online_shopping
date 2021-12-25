package com.company.service;

import com.company.converter.ProductConverter;
import com.company.dto.product.BulkProducts;
import com.company.dto.product.ProductCreateDTO;
import com.company.dto.product.ProductDTO;
import com.company.entity.Category;
import com.company.entity.Product;
import com.company.exceptions.ProductNotFoundException;
import com.company.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;

    public ProductDTO add(ProductCreateDTO dto){
        Category category = categoryService.getCategory(dto.getCategoryId());
        Product product = new Product();
        product.setName(dto.getName());
        product.setCategory(category);
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        productRepository.save(product);
        return ProductConverter.toDTO(product);
    }


    public List<ProductDTO> getProductList(){
        return productRepository.findAll().stream().map(ProductConverter::toDTO).collect(Collectors.toList());
    }


    public ProductDTO getById(Long id){
        Product product = getProduct(id);
        return ProductConverter.toDTO(product);
    }


    public List<BulkProducts> bulkProducts(){
        return productRepository.bulkProducts();
    }



    public Product getProduct(Long id){
        Optional<Product> optional = productRepository.findById(id);
        if (!optional.isPresent()) {
            throw new ProductNotFoundException("Product not found!!!");
        }
        return optional.get();
    }
}
