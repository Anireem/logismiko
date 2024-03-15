package com.logismiko.docs_auto_fill.api.endpoints;

import com.logismiko.docs_auto_fill.api.models.requests.OrganizationRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Represents the endpoint for working with organizations.
 */
@Tag(
    name = "Endpoint for working with organizations",
    description = "REST API to save and retrieve organizations data."
)
public interface OrganizationEndpoint {

    /**
     * [POST] /api/organizations
     */
    @Operation(summary = "Adds an organization to database.")
    @ApiResponse(
        responseCode = "201",
        description = "Success - organization successfully received."
    )
    @ApiResponse(
        responseCode = "400",
        description = "Bad Request - incorrect body format."
    )
    ResponseEntity<Void> addOrganization(
        OrganizationRequestDto organizationRequestDto,
        UriComponentsBuilder ucb
    );

    /**
     * [GET] /api/organizations/{id}
     */
    @Operation(summary = "Returns organization by ID.")
    @ApiResponse(
        responseCode = "200",
        description = "Success - organization successfully received.",
        content = {@Content(
            schema = @Schema(implementation = OrganizationResponseDto.class)
        )}
    )
    @ApiResponse(
        responseCode = "403",
        description = "Error - there is no organization with this ID in the"
            + " database.",
        content = @Content
    )
    ResponseEntity<OrganizationResponseDto> getOrganization(Long id);

    /**
     * [GET] /api/organizations
     */
    @Operation(summary = "Returns all organizations.")
    @ApiResponse(
        responseCode = "200",
        description = "Success - organizations successfully received."
    )
    ResponseEntity<Iterable<OrganizationResponseDto>>
    getOrganizations(Pageable pageable);

    /**
     * [DELETE] /api/organizations/{id}
     */
    @Operation(summary = "Delete organization.")
    @ApiResponse(
        responseCode = "204",
        description = "No content - organization successfully deleted."
    )
    @ApiResponse(
        responseCode = "404",
        description = "Not found - there is no organization with this ID"
            + "in the database."
    )
    ResponseEntity<Void> deleteOrganization(Long id);
}
