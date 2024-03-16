package com.logismiko.docs_auto_fill.api.endpoints;

import com.logismiko.docs_auto_fill.api.models.requests.FirmRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.FirmResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Represents the endpoint for working with firms.
 */
@Tag(
    name = "Endpoint for working with firms",
    description = "REST API to save and retrieve firms data."
)
public interface FirmEndpoint {

    /**
     * [POST] /api/firms
     */
    @Operation(summary = "Adds a firm to database.")
    @ApiResponse(
        responseCode = "201",
        description = "Success - firm successfully received."
    )
    @ApiResponse(
        responseCode = "400",
        description = "Bad Request - incorrect body format."
    )
    ResponseEntity<Void> addFirm(
        @RequestBody @Valid FirmRequestDto firmRequestDto,
        UriComponentsBuilder ucb
    );

    /**
     * [GET] /api/firms/{id}
     */
    @Operation(summary = "Returns firm by ID.")
    @ApiResponse(
        responseCode = "200",
        description = "Success - firm successfully received.",
        content = {@Content(
            schema = @Schema(implementation = FirmResponseDto.class)
        )}
    )
    @ApiResponse(
        responseCode = "403",
        description = "Error - there is no firm with this ID in the"
            + " database.",
        content = @Content
    )
    ResponseEntity<FirmResponseDto> getFirm(@PathVariable(value = "id") Long id);

    /**
     * [GET] /api/firms
     */
    @Operation(summary = "Returns all firms.")
    @ApiResponse(
        responseCode = "200",
        description = "Success - firms successfully received."
    )
    ResponseEntity<Iterable<FirmResponseDto>> getFirms(
        @ParameterObject Pageable pageable
    );

    /**
     * [DELETE] /api/firms/{id}
     */
    @Operation(summary = "Delete firm.")
    @ApiResponse(
        responseCode = "204",
        description = "No content - firm successfully deleted."
    )
    @ApiResponse(
        responseCode = "404",
        description = "Not found - there is no firm with this ID"
            + "in the database."
    )
    ResponseEntity<Void> deleteFirm(@PathVariable(value = "id") Long id);
}
