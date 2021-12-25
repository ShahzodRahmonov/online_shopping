package com.company.repository;

import com.company.dto.product.BulkProducts;
import com.company.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value="select distinct d.pr_id, p.price from detail d join product p on d.pr_id = p.id where d.quantity >= 8",nativeQuery=true)
    List<BulkProducts> bulkProducts();
}
