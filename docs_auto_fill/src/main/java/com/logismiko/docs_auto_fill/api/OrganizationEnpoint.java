package com.logismiko.docs_auto_fill.api;

import com.logismiko.docs_auto_fill.api.models.requests.OrganizationRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Represents an endpoint to work with vessel Organization data.
 */
@Tag(
        name = "Endpoint для работы с организациями",
        description = "REST API для сохранения и извлечения данных по организациям"
)
public interface OrganizationEnpoint {

    @Operation(summary = "Добавляет организацию в базу данных")
    @ApiResponse(
        responseCode = "201",
        description = "Success - организация успешно добавлена в базу."
    )
    @ApiResponse(
        responseCode = "400",
        description = "Bad Request - неправильный формат body."
    )
    ResponseEntity<Void> addOrganization(@RequestBody OrganizationRequestDto organizationRequestDto, UriComponentsBuilder ucb);

    @Operation(summary = "Возвращает организацию по ID.")
    @ApiResponse(
        responseCode = "200",
        description = "Success - организация успешно получена.",
        content = {@Content(schema = @Schema(implementation = OrganizationResponseDto.class))}
    )
    @ApiResponse(
        responseCode = "403",
        description = "Error - организации с таким ID нет в базе.",
        content = @Content
    )
    ResponseEntity<OrganizationResponseDto> getOrganization(Long id);

    @Operation(summary = "Возвращает список всех организаций.")
    @ApiResponse(
        responseCode = "200",
        description = "Success - успешно получены организации."
    )
    ResponseEntity<Iterable<OrganizationResponseDto>> getAllOrganizations();

    @Operation(summary = "Удаляет организацию.")
    @ApiResponse(
            responseCode = "204",
            description = "No content - организация успешно удалена."
    )
    @ApiResponse(
            responseCode = "404",
            description = "Not found - организации с таким ID нет в базе."
    )
    ResponseEntity<Void> deleteOrganization(@PathVariable(value = "id") Long id);
}
