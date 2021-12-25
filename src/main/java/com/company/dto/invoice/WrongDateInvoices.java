package com.company.dto.invoice;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface WrongDateInvoices {
    Long getId();
    LocalDate getIssued();
    Long getOrd_id();
    LocalDate getDate();
}
