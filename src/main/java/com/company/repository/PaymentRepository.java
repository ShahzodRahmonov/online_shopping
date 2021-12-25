package com.company.repository;

import com.company.dto.payment.OverpaidInvoices;
import com.company.entity.Customer;
import com.company.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

    @Query(value="select distinct p.inv_id, p.amount from payment p where p.inv_id in(select p2.inv_id from invoice i join payment p2 on p2.inv_id = i.id group by p2.inv_id having count(p2.id) > 1)",nativeQuery=true)
    List<OverpaidInvoices> overpaidInvoices();

}
