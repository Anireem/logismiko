package com.logismiko.docs_auto_fill.utils.factories;

import com.logismiko.docs_auto_fill.api.models.responses.FirmDataResponseDto;
import com.logismiko.docs_auto_fill.dao.entities.FirmDataEntity;
import com.logismiko.docs_auto_fill.utils.builders.FirmDataResponseDtoBuilder;

public final class FirmDataResponseDtoFactory {
    private FirmDataResponseDtoFactory() {
    }

    public static FirmDataResponseDto create(FirmDataEntity firmDataEntity) {
        return FirmDataResponseDtoBuilder.aFirmDataResponseDto()
            .withId(firmDataEntity.getId())
            .withDescription(firmDataEntity.getDescription())
            .withTitle(firmDataEntity.getTitle()).build();
    }
}
