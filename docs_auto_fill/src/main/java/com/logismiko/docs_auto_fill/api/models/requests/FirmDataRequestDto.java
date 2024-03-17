package com.logismiko.docs_auto_fill.api.models.requests;

import com.logismiko.docs_auto_fill.dao.entities.FirmDataEntity;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

/**
 * A DTO for the {@link FirmDataEntity} entity
 */
public record FirmDataRequestDto(
    @Schema(description = "Дополнительные сведения", example = "Количество сотрудников")
    String title,

    @Schema(description = "Описание дополнительных сведений", example = "50 человек")
    String description
) implements Serializable {
}