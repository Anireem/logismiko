package com.logismiko.docs_auto_fill.dao.repositories;

import com.logismiko.docs_auto_fill.dao.entities.FirmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FirmRepository
    extends
        JpaRepository<FirmEntity, Long>,
        PagingAndSortingRepository<FirmEntity, Long> {
}
