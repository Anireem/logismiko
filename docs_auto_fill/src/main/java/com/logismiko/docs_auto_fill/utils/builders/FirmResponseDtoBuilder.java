package com.logismiko.docs_auto_fill.utils.builders;

import com.logismiko.docs_auto_fill.api.models.responses.FirmDataResponseDto;
import com.logismiko.docs_auto_fill.api.models.responses.FirmResponseDto;

import java.util.Set;

public final class FirmResponseDtoBuilder {
    private String comment;
    private String contactName;
    private String email;
    private Long id;
    private String inn;
    private String kpp;
    private String longName;
    private String ogrn;
    private String okpo;
    private String okved;
    private String phone;
    private String shortName;
    private String view;
    private Set<FirmDataResponseDto> firmDataResponseDtoSet;

    private FirmResponseDtoBuilder() {
    }

    public static FirmResponseDtoBuilder anFirmResponseDto() {
        return new FirmResponseDtoBuilder();
    }

    public FirmResponseDtoBuilder withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public FirmResponseDtoBuilder withContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public FirmResponseDtoBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public FirmResponseDtoBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public FirmResponseDtoBuilder withInn(String inn) {
        this.inn = inn;
        return this;
    }

    public FirmResponseDtoBuilder withKpp(String kpp) {
        this.kpp = kpp;
        return this;
    }

    public FirmResponseDtoBuilder withLongName(String longName) {
        this.longName = longName;
        return this;
    }

    public FirmResponseDtoBuilder withOgrn(String ogrn) {
        this.ogrn = ogrn;
        return this;
    }

    public FirmResponseDtoBuilder withOkpo(String okpo) {
        this.okpo = okpo;
        return this;
    }

    public FirmResponseDtoBuilder withOkved(String okved) {
        this.okved = okved;
        return this;
    }

    public FirmResponseDtoBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public FirmResponseDtoBuilder withShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public FirmResponseDtoBuilder withView(String view) {
        this.view = view;
        return this;
    }

    public FirmResponseDtoBuilder withFirmDataResponseDtoSet(Set<FirmDataResponseDto> firmDataResponseDtoSet) {
        this.firmDataResponseDtoSet = firmDataResponseDtoSet;
        return this;
    }

    public FirmResponseDto build() {
        return new FirmResponseDto(comment, contactName, email, id, inn, kpp, longName, ogrn, okpo, okved, phone, shortName, view, firmDataResponseDtoSet);
    }
}
