package com.company.service;

import com.company.converter.DetailConverter;
import com.company.dto.detail.AddDetailDTO;
import com.company.dto.detail.DetailDTO;
import com.company.dto.detail.HighDemandProducts;
import com.company.entity.Detail;
import com.company.entity.Order;
import com.company.entity.Product;
import com.company.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailService {

    @Autowired
    private DetailRepository detailRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    public DetailDTO add(AddDetailDTO dto){
        Order order = orderService.getOrder(dto.getOrderId());
        Product product = productService.getProduct(dto.getProductId());
        Detail detail = new Detail();
        detail.setOrder(order);
        detail.setProduct(product);
        detail.setQuantity(dto.getQuantity());
        return DetailConverter.toDetailDTO(detailRepository.save(detail));
    }


    public Detail create(Order order, Product product, Integer quantity){
        Detail detail = new Detail();
        detail.setOrder(order);
        detail.setProduct(product);
        detail.setQuantity(quantity);
        return detailRepository.save(detail);
    }


    public List<HighDemandProducts> highDemandProducts(){
        return detailRepository.highDemandProducts();
    }

}
