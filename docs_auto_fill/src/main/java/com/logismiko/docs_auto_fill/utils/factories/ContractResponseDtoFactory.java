package com.logismiko.docs_auto_fill.utils.factories;

import com.logismiko.docs_auto_fill.api.models.responses.ContractResponseDto;
import com.logismiko.docs_auto_fill.dao.entities.ContractEntity;
import com.logismiko.docs_auto_fill.utils.builders.ContractResponseDtoBuilder;

public final class ContractResponseDtoFactory {
    private ContractResponseDtoFactory() {
    }

    public static final ContractResponseDto make(ContractEntity contractEntity) {
        return ContractResponseDtoBuilder.aContractResponseDto()
            .withId(contractEntity.getId())
            .withNumber(contractEntity.getNumber())
            .withAgreement(contractEntity.getAgreement())
            .withStart(contractEntity.getStart())
            .withExpiration(contractEntity.getExpiration())
            .withSum(contractEntity.getSum())
            .withCurrency(contractEntity.getCurrency())
            .withComment(contractEntity.getComment())
            .build();
    }
}
