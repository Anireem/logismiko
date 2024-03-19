package com.logismiko.docs_auto_fill.api.models.responses;

import com.logismiko.docs_auto_fill.dao.entities.ContractDataEntity;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * A DTO for the {@link ContractDataEntity} entity
 */
public record ContractDataResponseDto(
    @Schema(description = "Contract ID", example = "12")
    Long id,

    @Schema(description = "Additional data title", example = "Subject of the contract")
    String title,

    @Schema(description = "Additional data description", example = "The supplier undertakes to deliver, and the buyer...")
    String description
) {
}
