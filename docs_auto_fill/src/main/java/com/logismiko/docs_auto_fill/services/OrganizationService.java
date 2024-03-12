package com.logismiko.docs_auto_fill.services;

import com.logismiko.docs_auto_fill.api.models.requests.OrganizationRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;
import com.logismiko.docs_auto_fill.dao.entities.OrganizationEntity;
import com.logismiko.docs_auto_fill.dao.repositories.OrganizationRepository;
import com.logismiko.docs_auto_fill.services.factories.OrganizationEntityFactory;
import com.logismiko.docs_auto_fill.services.factories.OrganizationResponseDtoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public OrganizationResponseDto addOrganization(OrganizationRequestDto organizationRequestDto) {
        OrganizationEntity organizationEntity = OrganizationEntityFactory.make(organizationRequestDto);
        return OrganizationResponseDtoFactory.make(organizationRepository.save(organizationEntity));
    }

    public OrganizationResponseDto getOrganization(Long id) {
        return OrganizationResponseDtoFactory.make(
                organizationRepository.findById(id).orElseThrow(
                        () -> new RuntimeException(MessageFormat.format("Entity: {0} not found", id))
                )
        );
    }

    public List<OrganizationResponseDto> getAllOrganizations() {
        return organizationRepository.findAll()
                .stream()
                .map(OrganizationResponseDtoFactory::make)
                .toList();
    }

    public void deleteOrganization(Long id) {
        organizationRepository.deleteById(id);
    }
}
