package com.company.controller;

import com.company.dto.category.CategoryCreateDTO;
import com.company.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/category")
@Api(tags = "Category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ApiOperation("add new category")
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CategoryCreateDTO dto) {
        log.info("add new category: {} " + dto);
        return ResponseEntity.ok(categoryService.add(dto));
    }

    @ApiOperation("get all products category lists")
    @GetMapping("/list")
    public ResponseEntity<?> getList() {
        log.info("get all products category lists");
        return ResponseEntity.ok(categoryService.getList());
    }

    @ApiOperation("get category by id")
    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        log.info("get category by id: id = "+id);
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @ApiOperation("get category by product id")
    @GetMapping()
    public ResponseEntity<?> getCategoryProductId(@RequestParam("product_id") Long id) {
        log.info("get  category by product id: id = "+id);
        return ResponseEntity.ok(categoryService.getCategoryProductId(id));
    }
}


