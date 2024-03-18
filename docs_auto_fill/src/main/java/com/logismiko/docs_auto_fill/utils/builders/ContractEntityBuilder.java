package com.logismiko.docs_auto_fill.utils.builders;

import com.logismiko.docs_auto_fill.dao.entities.ContractEntity;

import java.time.LocalDateTime;

public final class ContractEntityBuilder {
    private Long id;
    private String number;
    private LocalDateTime agreement;
    private LocalDateTime start;
    private LocalDateTime expiration;
    private Long sum;
    private String currency;
    private String comment;

    private ContractEntityBuilder() {
    }

    public static ContractEntityBuilder aContractEntity() {
        return new ContractEntityBuilder();
    }

    public ContractEntityBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ContractEntityBuilder withNumber(String number) {
        this.number = number;
        return this;
    }

    public ContractEntityBuilder withAgreement(LocalDateTime agreement) {
        this.agreement = agreement;
        return this;
    }

    public ContractEntityBuilder withStart(LocalDateTime start) {
        this.start = start;
        return this;
    }

    public ContractEntityBuilder withExpiration(LocalDateTime expiration) {
        this.expiration = expiration;
        return this;
    }

    public ContractEntityBuilder withSum(Long sum) {
        this.sum = sum;
        return this;
    }

    public ContractEntityBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public ContractEntityBuilder withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public ContractEntity build() {
        ContractEntity contractEntity = new ContractEntity();
        contractEntity.setId(id);
        contractEntity.setNumber(number);
        contractEntity.setAgreement(agreement);
        contractEntity.setStart(start);
        contractEntity.setExpiration(expiration);
        contractEntity.setSum(sum);
        contractEntity.setCurrency(currency);
        contractEntity.setComment(comment);
        return contractEntity;
    }
}
