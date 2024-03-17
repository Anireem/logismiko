package com.logismiko.docs_auto_fill.utils.factories;

import com.logismiko.docs_auto_fill.api.models.responses.FirmResponseDto;
import com.logismiko.docs_auto_fill.dao.entities.FirmEntity;
import com.logismiko.docs_auto_fill.utils.builders.FirmResponseDtoBuilder;

import java.util.stream.Collectors;

/**
 * The type Firm response dto factory.
 */
public final class FirmResponseDtoFactory {

    private FirmResponseDtoFactory() {
    }

    /**
     * Make firm response dto firm response dto.
     *
     * @param firmEntity the firm entity
     * @return the firm response dto
     */
    public static FirmResponseDto create(FirmEntity firmEntity) {

        return FirmResponseDtoBuilder.anFirmResponseDto()
            .withComment(firmEntity.getComment())
            .withContactName(firmEntity.getContactName())
            .withEmail(firmEntity.getEmail())
            .withId(firmEntity.getId())
            .withInn(firmEntity.getInn())
            .withKpp(firmEntity.getKpp())
            .withLongName(firmEntity.getLongName())
            .withOgrn(firmEntity.getOgrn())
            .withOkpo(firmEntity.getOkpo())
            .withOkved(firmEntity.getOkved())
            .withPhone(firmEntity.getPhone())
            .withShortName(firmEntity.getShortName())
            .withView(firmEntity.getView())
            .withFirmDataResponseDtoSet(firmEntity
                .getFirmDataEntities()
                .stream()
                .map(FirmDataResponseDtoFactory::create)
                .collect(Collectors.toSet())
            ).build();
    }
}
