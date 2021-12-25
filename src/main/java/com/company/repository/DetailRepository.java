package com.company.repository;

import com.company.dto.detail.HighDemandProducts;
import com.company.entity.Detail;
import com.company.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DetailRepository extends JpaRepository<Detail,Long> {

    Optional<Detail> findByOrderId(Long id);

    @Query(value="select d.pr_id, count(d.pr_id) from detail d group by d.pr_id having count(d.pr_id)>10",nativeQuery=true)
    List<HighDemandProducts> highDemandProducts();

}
