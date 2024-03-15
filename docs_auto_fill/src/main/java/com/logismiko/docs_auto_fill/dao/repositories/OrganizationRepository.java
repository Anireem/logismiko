package com.logismiko.docs_auto_fill.dao.repositories;

import com.logismiko.docs_auto_fill.dao.entities.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrganizationRepository
    extends
        JpaRepository<OrganizationEntity, Long>,
        PagingAndSortingRepository<OrganizationEntity, Long> {
}
