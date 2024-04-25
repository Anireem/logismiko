package com.logismiko.docs_auto_fill.api.models.responses;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * A DTO for the {@link com.logismiko.docs_auto_fill.dao.entities.ContractEntity} entity
 */
public record ContractResponseDto(
    Long id,

    @Schema(description = "Contract number", example = "ND-132")
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
    String comment,

    @Schema(description = "Additional data sheet")
    Set<ContractDataResponseDto> contractDataEntities
) implements Serializable {
}