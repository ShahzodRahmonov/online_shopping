package com.company.controller;

import com.company.dto.product.ProductCreateDTO;
import com.company.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/product")
@Api(tags = "Product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("add product")
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ProductCreateDTO dto){
        log.info("add product: {} " + dto);
        return ResponseEntity.ok(productService.add(dto));
    }

    @ApiOperation("get product list")
    @GetMapping("/list")
    public ResponseEntity<?> getProductList(){
        log.info("get product list");
        return ResponseEntity.ok(productService.getProductList());
    }

    @ApiOperation("get product details by id")
    @GetMapping("/details")
    public ResponseEntity<?> getById(@RequestParam("product_id") Long id){
        log.info("get product details by id: id = "+id);
        return ResponseEntity.ok(productService.getById(id));
    }

    @ApiOperation("bulk_products")
    @GetMapping("/bulkProducts")
    public ResponseEntity<?> bulkProducts(){
        log.info("bulk_products");
        return ResponseEntity.ok(productService.bulkProducts());
    }
}
