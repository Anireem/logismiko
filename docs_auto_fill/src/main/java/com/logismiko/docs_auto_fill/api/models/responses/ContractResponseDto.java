package com.logismiko.docs_auto_fill.api.models.responses;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.logismiko.docs_auto_fill.dao.entities.ContractEntity} entity
 */
public record ContractResponseDto(
    Long id,
    String number,
    LocalDateTime agreement,
    LocalDateTime start,
    LocalDateTime expiration,
    Long sum,
    String currency,
    String comment
) implements Serializable {
}