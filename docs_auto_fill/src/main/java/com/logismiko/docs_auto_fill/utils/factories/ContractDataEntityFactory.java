package com.logismiko.docs_auto_fill.utils.factories;

import com.logismiko.docs_auto_fill.api.models.requests.ContractDataRequestDto;
import com.logismiko.docs_auto_fill.dao.entities.ContractDataEntity;
import com.logismiko.docs_auto_fill.utils.builders.ContractDataEntityBuilder;

public final class ContractDataEntityFactory {
    private ContractDataEntityFactory() {
    }

    public static ContractDataEntity create(
        ContractDataRequestDto contractDataRequestDto
    ) {
        return ContractDataEntityBuilder.aContractDataEntity()
            .withTitle(contractDataRequestDto.title())
            .withDescription(contractDataRequestDto.description())
            .build();
    }
}
