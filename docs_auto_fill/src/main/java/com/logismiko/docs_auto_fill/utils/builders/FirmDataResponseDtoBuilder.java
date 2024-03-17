package com.logismiko.docs_auto_fill.utils.builders;

import com.logismiko.docs_auto_fill.api.models.responses.FirmDataResponseDto;

public final class FirmDataResponseDtoBuilder {
    private Long id;
    private String title;
    private String description;

    private FirmDataResponseDtoBuilder() {
    }

    public static FirmDataResponseDtoBuilder aFirmDataResponseDto() {
        return new FirmDataResponseDtoBuilder();
    }

    public FirmDataResponseDtoBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public FirmDataResponseDtoBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public FirmDataResponseDtoBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public FirmDataResponseDto build() {
        return new FirmDataResponseDto(id, title, description);
    }
}
