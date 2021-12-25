package com.company.controller;

import com.company.dto.detail.AddDetailDTO;
import com.company.dto.detail.DetailDTO;
import com.company.service.DetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/detail")
@Api(tags = "Detail")
public class DetailController {

    @Autowired
    private DetailService detailService;

    @ApiOperation("add detail")
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AddDetailDTO dto){
        log.info("add detail: {} " + dto);
        return ResponseEntity.ok(detailService.add(dto));
    }
}
