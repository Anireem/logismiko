package com.logismiko.docs_auto_fill.utils.builders;

import com.logismiko.docs_auto_fill.api.models.responses.ContractDataResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;

public final class ContractDataResponseDtoBuilder {
    private @Schema(description = "Contract ID", example = "12") Long id;
    private @Schema(description = "Additional data title", example = "Subject of the contract") String title;
    private @Schema(description = "Additional data description", example = "The supplier undertakes to deliver, and the buyer...") String description;

    private ContractDataResponseDtoBuilder() {
    }

    public static ContractDataResponseDtoBuilder aContractDataResponseDto() {
        return new ContractDataResponseDtoBuilder();
    }

    public ContractDataResponseDtoBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ContractDataResponseDtoBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContractDataResponseDtoBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ContractDataResponseDto build() {
        return new ContractDataResponseDto(id, title, description);
    }
}
