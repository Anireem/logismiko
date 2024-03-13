package com.logismiko.docs_auto_fill.api.endpoints;

import com.logismiko.docs_auto_fill.api.models.requests.OrganizationRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Represents an endpoint to work with Organization data.
 */
@Tag(
    name = "Endpoint для работы с организациями",
    description = "REST API для сохранения и извлечения данных по организациям"
)
public interface OrganizationEndpoint {

    /**
     * [POST] /api/organizations
     */
    @Operation(summary = "Добавляет организацию в базу данных")
    @ApiResponse(
        responseCode = "201",
        description = "Success - организация успешно добавлена в базу."
    )
    @ApiResponse(
        responseCode = "400",
        description = "Bad Request - неправильный формат body."
    )
    ResponseEntity<Void> addOrganization(
            OrganizationRequestDto organizationRequestDto,
            UriComponentsBuilder ucb
    );

    /**
     * [GET] /api/organizations/{id}
     */
    @Operation(summary = "Возвращает организацию по ID.")
    @ApiResponse(
        responseCode = "200",
        description = "Success - организация успешно получена.",
        content = {@Content(
                schema = @Schema(implementation = OrganizationResponseDto.class)
        )}
    )
    @ApiResponse(
        responseCode = "403",
        description = "Error - организации с таким ID нет в базе.",
        content = @Content
    )
    ResponseEntity<OrganizationResponseDto> getOrganization(Long id);

    /**
     * [GET] /api/organizations
     */
    @Operation(summary = "Возвращает список всех организаций.")
    @ApiResponse(
        responseCode = "200",
        description = "Success - успешно получены организации."
    )
    ResponseEntity<Iterable<OrganizationResponseDto>> getAllOrganizations();

    /**
     * [DELETE] /api/organizations/{id}
     */
    @Operation(summary = "Удаляет организацию.")
    @ApiResponse(
        responseCode = "204",
        description = "No content - организация успешно удалена."
    )
    @ApiResponse(
        responseCode = "404",
        description = "Not found - организации с таким ID нет в базе."
    )
    ResponseEntity<Void> deleteOrganization(Long id);
}
