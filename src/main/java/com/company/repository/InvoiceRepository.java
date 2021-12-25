package com.company.repository;

import com.company.dto.invoice.WrongDateInvoices;
import com.company.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

    @Query(value="select * from invoice i where i.due < i.issued",nativeQuery=true)
    List<Invoice> expiredInvoices();

    Optional<Invoice> findByOrderId(Long id);

    @Query(value="select i.id, i.issued, i.ord_id, o.date from orders o join invoice i on o.id = i.ord_id where o.date > i.issued",nativeQuery=true)
    List<WrongDateInvoices> wrongDateInvoices();

}
