package com.company.service;

import com.company.converter.DetailConverter;
import com.company.converter.OrderConverter;
import com.company.dto.order.*;
import com.company.entity.*;
import com.company.enums.OrderStatus;
import com.company.exceptions.OrderFailedException;
import com.company.exceptions.OrderNotFoundException;
import com.company.repository.DetailRepository;
import com.company.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private DetailService detailService;
    @Autowired
    private DetailRepository detailRepository;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public OrderDTO add(OrderAddDTO dto){
        Customer customer = customerService.getCustomer(dto.getCustomerId());
        Order order = new Order();
        order.setCustomer(customer);
        order.setDate(LocalDate.parse(dto.getDate(),formatter));
        order.setStatus(OrderStatus.SUCCESS);
        return OrderConverter.toDTO(orderRepository.save(order));
    }


    public GetOrderDetailDTO getOrderDetail(Long id){
        Order order = this.getOrder(id);
        Optional<Detail> optional = detailRepository.findByOrderId(order.getId());
        if (!optional.isPresent()) {
            throw new OrderNotFoundException("this order has no details!!!");
        }
        return DetailConverter.toDTO(optional.get());
    }


    public List<CustomersLastOrders> customersLastOrders(){
        List<Long> idList = orderRepository.customersId();
        List<CustomersLastOrders> list = new ArrayList<>();
        if (idList.isEmpty()) {
            throw new OrderNotFoundException("Order not Found!!!");
        }
        for (Long id : idList) {
            Optional<CustomersLastOrders> optional = orderRepository.customersLastOrders(id);
            list.add(optional.get());
        }
        return list;
    }


    public List<OrderDTO> ordersWithoutDetails(){
        return orderRepository.ordersWithoutDetails().stream().map(OrderConverter::toDTO).collect(Collectors.toList());
    }


    public List<OrdersWithoutInvoices> ordersWithoutInvoices(){
        return orderRepository.ordersWithoutInvoices();
    }


    public Order getOrder(Long id){
        Optional<Order> optional = orderRepository.findById(id);
        if (!optional.isPresent()) {
            throw new OrderNotFoundException("Order not found!!!");
        }
        return optional.get();
    }


    public OrderResponseDTO add2(OrderCreateDTO dto){
        Customer customer = customerService.getCustomer(dto.getCustomerId());
        Product product = productService.getProduct(dto.getProductId());
        Order order = new Order();
        order.setCustomer(customer);
        order.setDate(LocalDate.now());
        order.setStatus(OrderStatus.SUCCESS);
        orderRepository.save(order);
        Detail detail = detailService.create(order,product,dto.getQuantity());
        Invoice invoice = invoiceService.add2(dto.getQuantity(),order,product);
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setOrderStatus(order.getStatus());
        orderResponseDTO.setInvoiceId(invoice.getId());
        return orderResponseDTO;
    }

}
