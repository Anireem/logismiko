package com.logismiko.docs_auto_fill.api.models.responses;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

/**
 * A DTO for the {@link com.logismiko.docs_auto_fill.dao.entities.FirmDataEntity} entity
 */
public record FirmDataResponseDto(
    @Schema(description = "Firm ID", example = "204")
    Long id,

    @Schema(description = "Additional data, title", example = "Количество сотрудников")
    String title,

    @Schema(description = "Additional data, description", example = "50 человек")
    String description
) implements Serializable {
}