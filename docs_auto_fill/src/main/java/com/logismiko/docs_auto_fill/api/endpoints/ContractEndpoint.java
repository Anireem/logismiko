package com.logismiko.docs_auto_fill.api.endpoints;

import com.logismiko.docs_auto_fill.api.models.requests.ContractRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.ContractResponseDto;
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
 * Represents the endpoint for working with Contracts.
 */
@Tag(
    name = "Endpoint for working with Contracts",
    description = "REST API to save and retrieve contracts data."
)
public interface ContractEndpoint {
    /**
     * [POST] /api/contracts
     */
    @Operation(summary = "Adds Contract to database.")
    @ApiResponse(
        responseCode = "201",
        description = "Success, contract successfully received."
    )
    @ApiResponse(
        responseCode = "401",
        description = "Bad request, incorrect body format."
    )
    ResponseEntity<Void> addContract(
        @RequestBody @Valid ContractRequestDto contractRequestDto,
        UriComponentsBuilder ucb
    );

    /**
     * [GET] /api/contracts/{id}
     */
    @Operation(summary = "Returns Contract by ID.")
    @ApiResponse(
        responseCode = "200",
        description = "Success - Contract successfully received.",
        content = {@Content(
            schema = @Schema(implementation = ContractResponseDto.class)
        )}
    )
    @ApiResponse(
        responseCode = "403",
        description = "Error - there is no Contract with this ID in the"
            + " database.",
        content = @Content
    )
    ResponseEntity<ContractResponseDto> getContract(@PathVariable(value = "id") Long id);

    /**
     * [GET] /api/contracts
     */
    @Operation(summary = "Returns all Contracts.")
    @ApiResponse(
        responseCode = "200",
        description = "Success - Contracts successfully received."
    )
    ResponseEntity<Iterable<ContractResponseDto>> getContracts(
        @ParameterObject Pageable pageable
    );

    /**
     * [DELETE] /api/contracts/{id}
     */
    @Operation(summary = "Delete Contract.")
    @ApiResponse(
        responseCode = "204",
        description = "No content - Contract successfully deleted."
    )
    @ApiResponse(
        responseCode = "404",
        description = "Not found - there is no Contract with this ID"
            + "in the database."
    )
    ResponseEntity<Void> deleteContract(@PathVariable(value = "id") Long id);
}
