package com.logismiko.docs_auto_fill.services;

import com.logismiko.docs_auto_fill.api.models.requests.OrganizationRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;
import com.logismiko.docs_auto_fill.dao.entities.OrganizationEntity;
import com.logismiko.docs_auto_fill.dao.repositories.OrganizationRepository;
import com.logismiko.docs_auto_fill.utils.factories.OrganizationEntityFactory;
import com.logismiko.docs_auto_fill.utils.factories.OrganizationResponseDtoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Represents service layer for working with organizations.
 */
@Service
public class OrganizationService {

    /**
     * Repository for working with organizations.
     */
    private OrganizationRepository organizationRepository;

    /**
     * Constructor, parameters are filled using Dependency Injection.
     * @param organizationRepository Repository for working with organizations.
     */
    @Autowired
    public OrganizationService(
        final OrganizationRepository organizationRepository
    ) {
        this.organizationRepository = organizationRepository;
    }

    /**
     * Adds organization to database.
     * @param organizationRequestDto DTO for organization creation.
     * @return DTO of a newly created organization.
     */
    public OrganizationResponseDto addOrganization(
        final OrganizationRequestDto organizationRequestDto
    ) {
        OrganizationEntity organizationEntity = OrganizationEntityFactory
            .makeOrganizationEntity(organizationRequestDto);
        return OrganizationResponseDtoFactory.makeOrganizationResponseDto(
            organizationRepository.save(organizationEntity)
        );
    }

    /**
     * Retrieves organization from database by id.
     * @param id Organization ID.
     * @return Found organization DTO.
     */
    public OrganizationResponseDto getOrganizationById(final Long id) {
        return OrganizationResponseDtoFactory.makeOrganizationResponseDto(
            organizationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                    NOT_FOUND, String.format("Entity: %s not found", 1L)
                )
            )
        );
    }

    /**
     * Returns page of organizations as list of organization response DTOs.
     * @param pageable consists page number, size and sort type.
     * @return list of organization response DTOs.
     */
    public List<OrganizationResponseDto> getOrganizations(
        final Pageable pageable
    ) {
        return retrieveOrganizations(pageable)
            .getContent()
            .stream()
            .map(OrganizationResponseDtoFactory::makeOrganizationResponseDto)
            .toList();
    }

    /**
     * Remove organization from database if it exists.
     * @param id ID of the organization to be deleted.
     */
    public void deleteOrganization(final Long id) {
        if (organizationRepository.existsById(id)) {
            organizationRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                NOT_FOUND,
                String.format("Entity: %s not found", 1L)
            );
        }
    }

    //region Private methods

    /**
     * Private method, retrieves page of organizations.
     * @param pageable Consists page number, size and sort type.
     * @return Page of organizations.
     */
    private Page<OrganizationEntity> retrieveOrganizations(
        final Pageable pageable
    ) {
        try {
            return organizationRepository.findAll(pageable);
        } catch (Exception e) {
            throw new ResponseStatusException(BAD_REQUEST,
                "Error retrieving organizations", e);
        }
    }

    //endregion
}
