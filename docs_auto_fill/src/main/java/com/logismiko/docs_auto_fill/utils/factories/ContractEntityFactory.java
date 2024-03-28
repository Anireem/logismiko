package com.logismiko.docs_auto_fill.utils.factories;

import com.logismiko.docs_auto_fill.api.models.requests.ContractDataRequestDto;
import com.logismiko.docs_auto_fill.api.models.requests.ContractRequestDto;
import com.logismiko.docs_auto_fill.dao.entities.ContractDataEntity;
import com.logismiko.docs_auto_fill.dao.entities.ContractEntity;
import com.logismiko.docs_auto_fill.utils.builders.ContractEntityBuilder;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public final class ContractEntityFactory {

    private ContractEntityFactory() {
    }

    public static ContractEntity create(ContractRequestDto contractRequestDto) {
        Set<ContractDataRequestDto> contractDataRequestDtoSet = Optional
            .ofNullable(contractRequestDto.contractDataRequestDtoSet())
            .orElse(new LinkedHashSet<>());

        Set<ContractDataEntity> contractDataEntities = contractDataRequestDtoSet
            .stream()
            .map(ContractDataEntityFactory::create)
            .collect(Collectors.toSet());

        ContractEntity contractEntity = ContractEntityBuilder.aContractEntity()
            .withNumber(contractRequestDto.number())
            .withAgreement(contractRequestDto.agreement())
            .withStart(contractRequestDto.start())
            .withExpiration(contractRequestDto.expiration())
            .withSum(contractRequestDto.sum())
            .withCurrency(contractRequestDto.currency())
            .withComment(contractRequestDto.comment())
            .withContractDataEntities(contractDataEntities)
            .build();

        contractEntity.getContractDataEntities().forEach(contractDataEntity ->
            contractDataEntity.setContractEntity(contractEntity));

        return contractEntity;
    }
}
