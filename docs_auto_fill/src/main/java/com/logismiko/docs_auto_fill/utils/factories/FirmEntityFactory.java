package com.logismiko.docs_auto_fill.utils.factories;

import com.logismiko.docs_auto_fill.api.models.requests.FirmRequestDto;
import com.logismiko.docs_auto_fill.dao.entities.FirmEntity;
import com.logismiko.docs_auto_fill.utils.builders.FirmEntityBuilder;

import java.util.stream.Collectors;

/**
 * The type Firm entity factory.
 */
public final class FirmEntityFactory {

    private FirmEntityFactory() {
    }

    /**
     * Make firm entity firm entity.
     *
     * @param firmRequestDto the firm request dto
     * @return the firm entity
     */
    public static FirmEntity create(FirmRequestDto firmRequestDto) {
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
            .withFirmDataEntities(firmRequestDto
                .firmDataRequestDtoSet()
                .stream()
                .map(FirmDataEntityFactory::create)
                .collect(Collectors.toSet()))
            .build();
        firmEntity.getFirmDataEntities()
            .forEach(firmDataEntity -> firmDataEntity.setFirmEntity(firmEntity));
        return firmEntity;
    }
}
