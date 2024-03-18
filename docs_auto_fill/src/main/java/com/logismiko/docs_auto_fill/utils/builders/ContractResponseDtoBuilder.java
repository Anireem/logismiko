package com.logismiko.docs_auto_fill.utils.builders;

import com.logismiko.docs_auto_fill.api.models.responses.ContractResponseDto;

import java.time.LocalDateTime;

public final class ContractResponseDtoBuilder {
    private Long id;
    private String number;
    private LocalDateTime agreement;
    private LocalDateTime start;
    private LocalDateTime expiration;
    private Long sum;
    private String currency;
    private String comment;

    private ContractResponseDtoBuilder() {
    }

    public static ContractResponseDtoBuilder aContractResponseDto() {
        return new ContractResponseDtoBuilder();
    }

    public ContractResponseDtoBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ContractResponseDtoBuilder withNumber(String number) {
        this.number = number;
        return this;
    }

    public ContractResponseDtoBuilder withAgreement(LocalDateTime agreement) {
        this.agreement = agreement;
        return this;
    }

    public ContractResponseDtoBuilder withStart(LocalDateTime start) {
        this.start = start;
        return this;
    }

    public ContractResponseDtoBuilder withExpiration(LocalDateTime expiration) {
        this.expiration = expiration;
        return this;
    }

    public ContractResponseDtoBuilder withSum(Long sum) {
        this.sum = sum;
        return this;
    }

    public ContractResponseDtoBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public ContractResponseDtoBuilder withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public ContractResponseDto build() {
        return new ContractResponseDto(id, number, agreement, start, expiration, sum, currency, comment);
    }
}
