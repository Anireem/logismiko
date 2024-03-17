package com.logismiko.docs_auto_fill.api.models.requests;

import com.logismiko.docs_auto_fill.dao.entities.FirmDataEntity;

import java.io.Serializable;

/**
 * A DTO for the {@link FirmDataEntity} entity
 */
public record FirmDataRequestDto(Long id, String title, String description) implements Serializable {
}