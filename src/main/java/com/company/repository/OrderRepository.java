package com.company.repository;

import com.company.dto.order.CustomersLastOrders;
import com.company.dto.order.OrdersWithoutInvoices;
import com.company.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query(value="select * from orders o where o.id not in (select d.ord_id from detail d) and o.date < '2016-09-06'",nativeQuery=true)
    List<Order> ordersWithoutDetails();

    @Query(value="select d.ord_id, o.date, d.quantity * p.price as total_price from orders o join detail d on d.ord_id = o.id join product p on p.id = d.pr_id where o.id not in (select i.ord_id from invoice i)",nativeQuery=true)
    List<OrdersWithoutInvoices> ordersWithoutInvoices();

    @Query(value="select distinct c.id from orders o join customer c on c.id = o.cust_id",nativeQuery=true)
    List<Long> customersId();

    @Query(value="select o.cust_id, c.name, o.date from orders o join customer c on c.id = o.cust_id where c.id=:id order by o.date desc limit 1",nativeQuery=true)
    Optional<CustomersLastOrders> customersLastOrders(@Param("id") Long id);
}
