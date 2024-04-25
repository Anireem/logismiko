package com.logismiko.docs_auto_fill.utils.builders;

import com.logismiko.docs_auto_fill.dao.entities.ContractDataEntity;

public final class ContractDataEntityBuilder {
    private String title;
    private String description;

    private ContractDataEntityBuilder() {
    }

    public static ContractDataEntityBuilder aContractDataEntity() {
        return new ContractDataEntityBuilder();
    }

    public ContractDataEntityBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContractDataEntityBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ContractDataEntity build() {
        ContractDataEntity contractDataEntity = new ContractDataEntity();
        contractDataEntity.setTitle(title);
        contractDataEntity.setDescription(description);
        return contractDataEntity;
    }
}
