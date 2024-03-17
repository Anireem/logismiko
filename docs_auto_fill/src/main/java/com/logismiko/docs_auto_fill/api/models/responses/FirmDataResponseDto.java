package com.logismiko.docs_auto_fill.api.models.responses;

import java.io.Serializable;

/**
 * A DTO for the {@link com.logismiko.docs_auto_fill.dao.entities.FirmDataEntity} entity
 */
public record FirmDataResponseDto(Long id, String title, String description) implements Serializable {
}