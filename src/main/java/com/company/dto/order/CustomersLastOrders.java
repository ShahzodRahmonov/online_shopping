package com.company.dto.order;

import java.time.LocalDate;

public interface CustomersLastOrders {
    Long getCust_id();
    String getName();
    LocalDate getDate();
}
