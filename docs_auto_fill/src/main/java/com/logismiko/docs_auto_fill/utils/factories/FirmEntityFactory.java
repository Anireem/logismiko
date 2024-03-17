package com.logismiko.docs_auto_fill.utils.factories;

import com.logismiko.docs_auto_fill.api.models.requests.FirmDataRequestDto;
import com.logismiko.docs_auto_fill.api.models.requests.FirmRequestDto;
import com.logismiko.docs_auto_fill.dao.entities.FirmDataEntity;
import com.logismiko.docs_auto_fill.dao.entities.FirmEntity;
import com.logismiko.docs_auto_fill.utils.builders.FirmEntityBuilder;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Firm entity factory.
 */
public final class FirmEntityFactory {

    private FirmEntityFactory() {
    }

    /**
     * Make Firm entity, based on the Firm request DTO.
     *
     * @param firmRequestDto the firm request dto.
     * @return the firm entity.
     */
    public static FirmEntity create(FirmRequestDto firmRequestDto) {
        Set<FirmDataRequestDto> firmDataRequestDtoSet = Optional
            .ofNullable(firmRequestDto.firmDataRequestDtoSet())
            .orElse(new LinkedHashSet<>());

        Set<FirmDataEntity> firmDataEntities = firmDataRequestDtoSet.stream()
            .map(FirmDataEntityFactory::create)
            .collect(Collectors.toSet());

        FirmEntity firmEntity = FirmEntityBuilder.anFirmEntity()
            .withComment(firmRequestDto.comment())
            .withContactName(firmRequestDto.contactName())
            .withEmail(firmRequestDto.email())
            .withInn(firmRequestDto.inn())
            .withKpp(firmRequestDto.kpp())
            .withLongName(firmRequestDto.longName())
            .withOgrn(firmRequestDto.ogrn())
            .withOkpo(firmRequestDto.okpo())
            .withOkved(firmRequestDto.okved())
            .withPhone(firmRequestDto.phone())
            .withShortName(firmRequestDto.shortName())
            .withView(firmRequestDto.view())
            .withFirmDataEntities(firmDataEntities)
            .build();

        firmEntity.getFirmDataEntities().forEach(
            firmDataEntity -> firmDataEntity.setFirmEntity(firmEntity)
        );

        return firmEntity;
    }
}
