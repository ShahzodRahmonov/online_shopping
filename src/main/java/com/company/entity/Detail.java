package com.company.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "detail")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ord_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pr_id")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;
}
