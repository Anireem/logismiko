package com.logismiko.docs_auto_fill.dao.repositories;

import com.logismiko.docs_auto_fill.dao.entities.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContractRepository
    extends
        JpaRepository<ContractEntity, Long>,
        PagingAndSortingRepository<ContractEntity, Long> {
}
