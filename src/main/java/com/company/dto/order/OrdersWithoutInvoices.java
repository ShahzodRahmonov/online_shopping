package com.company.dto.order;

import java.time.LocalDate;

public interface OrdersWithoutInvoices {
     Long getOrd_id();
     LocalDate getDate();
     Double getTotal_price();
}
