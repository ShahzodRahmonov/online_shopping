package com.company.service;

import com.company.converter.CustomerConverter;
import com.company.dto.customer.CustomerCreateDTO;
import com.company.dto.customer.CustomerDTO;
import com.company.dto.customer.NumberOfProductsInYear;
import com.company.entity.Customer;
import com.company.exceptions.CustomerNotFoundException;
import com.company.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDTO add(CustomerCreateDTO dto){
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setPhone(dto.getPhone());
        customer.setAddress(dto.getAddress());
        customer.setCountry(dto.getCountry());
        customerRepository.save(customer);
        return CustomerConverter.toDTO(customer);
    }


    public Customer getCustomer(Long id){
        Optional<Customer> optional = customerRepository.findById(id);
        if (!optional.isPresent()) {
            throw new CustomerNotFoundException("Customer not found!!!");
        }
        return optional.get();
    }


    public List<CustomerDTO> customersWithoutOrders(){
        return customerRepository.customersWithoutOrders().stream().map(CustomerConverter::toDTO).collect(Collectors.toList());
    }


    public List<NumberOfProductsInYear> numberOfProductsInYear(){
        return customerRepository.numberOfProductsInYear();
    }
}
