package com.company.repository;

import com.company.dto.customer.NumberOfProductsInYear;
import com.company.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query(value="select * from customer c where c.id not in(select o.cust_id from orders o where date_part('year',o.date) = 2016)",nativeQuery=true)
    List<Customer> customersWithoutOrders();

    @Query(value="select c.country, count(o.id) from customer c join orders o  on c.id = o.cust_id where date_part('year',o.date) = 2016 group by c.country",nativeQuery=true)
    List<NumberOfProductsInYear> numberOfProductsInYear();

}
