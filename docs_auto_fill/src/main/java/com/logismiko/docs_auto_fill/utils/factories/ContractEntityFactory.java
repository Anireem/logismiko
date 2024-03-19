package com.logismiko.docs_auto_fill.utils.factories;

import com.logismiko.docs_auto_fill.api.models.requests.ContractRequestDto;
import com.logismiko.docs_auto_fill.dao.entities.ContractEntity;
import com.logismiko.docs_auto_fill.utils.builders.ContractEntityBuilder;

public final class ContractEntityFactory {
    private ContractEntityFactory() {
    }

    public static ContractEntity make(ContractRequestDto contractRequestDto) {
        return ContractEntityBuilder.aContractEntity()
            .withNumber(contractRequestDto.number())
            .withAgreement(contractRequestDto.agreement())
            .withStart(contractRequestDto.start())
            .withExpiration(contractRequestDto.expiration())
            .withSum(contractRequestDto.sum())
            .withCurrency(contractRequestDto.currency())
            .withComment(contractRequestDto.comment())
            .build();
    }
}
