package com.logismiko.docs_auto_fill.services;

import com.logismiko.docs_auto_fill.api.models.requests.OrganizationRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;
import com.logismiko.docs_auto_fill.dao.entities.OrganizationEntity;
import com.logismiko.docs_auto_fill.dao.repositories.OrganizationRepository;
import com.logismiko.docs_auto_fill.utils.factories.OrganizationEntityFactory;
import com.logismiko.docs_auto_fill.utils.factories.OrganizationResponseDtoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Represents a service to work with Organizations.
 * @param organizationRepository Repository for storing
 * and retrieving data by organization
 */
@Service
public record OrganizationService(
        @Autowired OrganizationRepository organizationRepository
) {

    /**
     * Creates Organization.
     * @param organizationRequestDto DTO to create an Organization.
     * @return Created Organization response DTO.
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
     * Retrieves the Organization by ID.
     * @param id Organization ID.
     * @return Organization response DTO.
     */
    public OrganizationResponseDto getOrganization(final Long id) {
        return OrganizationResponseDtoFactory.makeOrganizationResponseDto(
            organizationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        NOT_FOUND, String.format("Entity: %s not found", 1L)
                )
            )
        );
    }

    /**
     * Get all Organizations from database.
     * @return List of Organization DTOs.
     */
    public List<OrganizationResponseDto> getAllOrganizations() {
        return organizationRepository.findAll()
                .stream()
                .map(
                    OrganizationResponseDtoFactory::makeOrganizationResponseDto
                )
                .toList();
    }

    /**
     * Delete an organization, if it exists.
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
}
