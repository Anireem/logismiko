package com.logismiko.docs_auto_fill.controllers;

import com.logismiko.docs_auto_fill.api.endpoints.OrganizationEndpoint;
import com.logismiko.docs_auto_fill.api.models.requests.OrganizationRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;
import com.logismiko.docs_auto_fill.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static com.logismiko.docs_auto_fill.api.constants.ApiRoutes.Organization.ORGANIZATION_CONTEXT_PATH;

/**
 * Contains methods to work with Organizations.
 * @param organizationService Service layer for working with organizations.
 */

@RestController
@RequestMapping(ORGANIZATION_CONTEXT_PATH)
public record OrganizationController(
        @Autowired OrganizationService organizationService
) implements OrganizationEndpoint {

    /**
     * Adds Organization to database.
     * @param organizationRequestDto DTO to create an Organization.
     * @param ucb Service parameter, filled in automatically.
     * @return Response entity with 201(created) code and new object location.
     */
    @PostMapping
    @Override
    public ResponseEntity<Void> addOrganization(
            @RequestBody final OrganizationRequestDto organizationRequestDto,
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
     * Retrieves an Organization by ID.
     * @param id Organization ID.
     * @return Response entity with 200 code and body with Organization.
     */
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<OrganizationResponseDto> getOrganization(
            @PathVariable(value = "id") final Long id
    ) {
        return ResponseEntity.ok(organizationService.getOrganization(id));
    }

    /**
     * Retrieves list of all Organizations, without pagination.
     * @return Response entity with list of all Organizations in the body.
     */
    @GetMapping
    public
    ResponseEntity<Iterable<OrganizationResponseDto>> getAllOrganizations() {
        return ResponseEntity.ok(organizationService.getAllOrganizations());
    }

    /**
     * Delete organization by ID from database.
     * @param id Organization ID.
     * @return Only response entity with 204 code, without content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(
            @PathVariable(value = "id") final Long id
    ) {
        organizationService.deleteOrganization(id);
        return ResponseEntity.noContent().build();
    }
}
