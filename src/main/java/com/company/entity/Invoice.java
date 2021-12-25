package com.company.entity;

import com.company.enums.OrderStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ord_id")
    private Order order;

    @Column(name = "amound", nullable = false)
    private Double amound;

    @Column(name = "issued", nullable = false)
    private LocalDate issued;

    @Column(name = "due", nullable = false)
    private LocalDate due;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;
}
