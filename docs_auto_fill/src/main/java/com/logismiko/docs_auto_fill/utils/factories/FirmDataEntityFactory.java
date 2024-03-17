package com.logismiko.docs_auto_fill.utils.factories;

import com.logismiko.docs_auto_fill.api.models.requests.FirmDataRequestDto;
import com.logismiko.docs_auto_fill.dao.entities.FirmDataEntity;
import com.logismiko.docs_auto_fill.utils.builders.FirmDataEntityBuilder;

public class FirmDataEntityFactory {
    public static FirmDataEntity create(FirmDataRequestDto firmDataRequestDto) {
        return FirmDataEntityBuilder.aFirmDataEntity()
            .withTitle(firmDataRequestDto.title())
            .withDescription(firmDataRequestDto.description())
            .build();
    }
}
