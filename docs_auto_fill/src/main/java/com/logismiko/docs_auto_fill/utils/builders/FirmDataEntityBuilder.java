package com.logismiko.docs_auto_fill.utils.builders;

import com.logismiko.docs_auto_fill.dao.entities.FirmDataEntity;
import com.logismiko.docs_auto_fill.dao.entities.FirmEntity;

public final class FirmDataEntityBuilder {
    private Long id;
    private String title;
    private String description;
    private FirmEntity firmEntity;

    private FirmDataEntityBuilder() {
    }

    public static FirmDataEntityBuilder aFirmDataEntity() {
        return new FirmDataEntityBuilder();
    }

    public FirmDataEntityBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public FirmDataEntityBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public FirmDataEntityBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public FirmDataEntityBuilder withFirmEntity(FirmEntity firmEntity) {
        this.firmEntity = firmEntity;
        return this;
    }

    public FirmDataEntity build() {
        FirmDataEntity firmDataEntity = new FirmDataEntity();
        firmDataEntity.setId(id);
        firmDataEntity.setTitle(title);
        firmDataEntity.setDescription(description);
        firmDataEntity.setFirmEntity(firmEntity);
        return firmDataEntity;
    }
}
