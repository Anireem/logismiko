package com.logismiko.docs_auto_fill.api.models.requests;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.logismiko.docs_auto_fill.dao.entities.ContractEntity} entity
 */
public record ContractRequestDto(
    @Schema(description = "Contract number", example = "НД-132")
    String number,

    @Schema(description = "Agreement date")
    LocalDateTime agreement,

    @Schema(description = "Start date")
    LocalDateTime start,

    @Schema(description = "Expiration date")
    LocalDateTime expiration,

    @Schema(description = "Amount of the dead", example = "500000")
    Long sum,

    @Schema(description = "Currency", example = "Rub")
    String currency,

    @Schema(description = "Comment", example = "Important contract.")
    String comment
) implements Serializable {
}