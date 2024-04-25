package com.logismiko.docs_auto_fill.dao.repositories;

import com.logismiko.docs_auto_fill.dao.entities.FirmEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FirmRepository
    extends
        JpaRepository<FirmEntity, Long>,
        PagingAndSortingRepository<FirmEntity, Long> {

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = "firmDataEntities")
    Page<FirmEntity> findAll(Pageable pageable);
}
