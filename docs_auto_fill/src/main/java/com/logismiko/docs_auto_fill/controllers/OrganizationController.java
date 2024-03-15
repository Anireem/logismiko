package com.logismiko.docs_auto_fill.controllers;

import com.logismiko.docs_auto_fill.api.endpoints.OrganizationEndpoint;
import com.logismiko.docs_auto_fill.api.models.requests.OrganizationRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;
import com.logismiko.docs_auto_fill.errors.handlers.ControllerExceptionHandler;
import com.logismiko.docs_auto_fill.services.OrganizationService;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static com.logismiko.docs_auto_fill.api.constants.ApiRoutes.Organization.ORGANIZATION_CONTEXT_PATH;

/**
 * Represents methods for working with organizations.
 */
@RestController
@RequestMapping(ORGANIZATION_CONTEXT_PATH)
public class OrganizationController
    implements OrganizationEndpoint, ControllerExceptionHandler {

    /**
     * Service layer for working with organizations.
     */
    private final OrganizationService organizationService;

    /**
     * Constructor, parameters are filled using Dependency Injection.
     * @param organizationService Service layer for working with organizations.
     */
    @Autowired
    public OrganizationController(
        final OrganizationService organizationService
    ) {
        this.organizationService = organizationService;
    }

    /**
     * Adds organization to the database.
     * @param organizationRequestDto DTO for creating an organization.
     * @param ucb Service parameter, filled in automatically,
     * @return ResponseEntity with code 200 (with a link to a new element),
     * or with code 400.
     */
    @PostMapping
    @Override
    public ResponseEntity<Void> addOrganization(
        @RequestBody
        @Valid
        final OrganizationRequestDto organizationRequestDto,
        final UriComponentsBuilder ucb
    ) {
        OrganizationResponseDto organizationResponseDto =
            organizationService.addOrganization(organizationRequestDto);
        URI location = ucb
            .path(ORGANIZATION_CONTEXT_PATH + "/{id}")
            .buildAndExpand(organizationResponseDto.id())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    /**
     * Get organization by ID.
     * @param id Organization ID.
     * @return ResponseEntity with code 200 and body containing
     * the organization's DTO.
     */
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<OrganizationResponseDto> getOrganization(
        @PathVariable(value = "id")
        final Long id
    ) {
        return ResponseEntity.ok(organizationService.getOrganizationById(id));
    }

    /**
     * Get list of organizations, without pagination.
     * @return Response entity with list of organizations in the body.
     */
    @GetMapping
    @Override
    public ResponseEntity<Iterable<OrganizationResponseDto>>
    getAllOrganizations() {
        return ResponseEntity.ok(organizationService.getAllOrganizations());
    }

    /**
     * Returns page of organizations as list of organization response DTOs.
     * @param pageable consists page number, size and sort type,
     *                 service parameter, filled in automatically.
     * @return list of organization response DTOs.
     */
    @GetMapping("/page")
    @Override
    public ResponseEntity<Iterable<OrganizationResponseDto>>
    getOrganizationsAsPage(@ParameterObject Pageable pageable) {
        return ResponseEntity.ok(
            organizationService.getOrganizationsAsPage(pageable)
        );
    }

    /**
     * Delete organization by ID from database.
     * @param id organization ID.
     * @return ResponseEntity with code 204, without extra content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(
        @PathVariable(value = "id")
        final Long id
    ) {
        organizationService.deleteOrganization(id);
        return ResponseEntity.noContent().build();
    }
}
