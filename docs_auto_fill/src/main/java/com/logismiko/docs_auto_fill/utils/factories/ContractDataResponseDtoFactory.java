package com.logismiko.docs_auto_fill.utils.factories;

import com.logismiko.docs_auto_fill.api.models.responses.ContractDataResponseDto;
import com.logismiko.docs_auto_fill.dao.entities.ContractDataEntity;
import com.logismiko.docs_auto_fill.utils.builders.ContractDataResponseDtoBuilder;

public final class ContractDataResponseDtoFactory {
    private ContractDataResponseDtoFactory() {
    }

    public static final ContractDataResponseDto create(
        ContractDataEntity contractDataEntity
    ) {
        return ContractDataResponseDtoBuilder.aContractDataResponseDto()
            .withId(contractDataEntity.getId())
            .withDescription(contractDataEntity.getDescription())
            .withTitle(contractDataEntity.getTitle()).build();
    }
}
