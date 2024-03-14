package com.logismiko.docs_auto_fill.utils.builders;

import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;

public final class OrganizationResponseDtoBuilder {
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

    private OrganizationResponseDtoBuilder() {
    }

    public static OrganizationResponseDtoBuilder anOrganizationResponseDto() {
        return new OrganizationResponseDtoBuilder();
    }

    public OrganizationResponseDtoBuilder withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public OrganizationResponseDtoBuilder withContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public OrganizationResponseDtoBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public OrganizationResponseDtoBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public OrganizationResponseDtoBuilder withInn(String inn) {
        this.inn = inn;
        return this;
    }

    public OrganizationResponseDtoBuilder withKpp(String kpp) {
        this.kpp = kpp;
        return this;
    }

    public OrganizationResponseDtoBuilder withLongName(String longName) {
        this.longName = longName;
        return this;
    }

    public OrganizationResponseDtoBuilder withOgrn(String ogrn) {
        this.ogrn = ogrn;
        return this;
    }

    public OrganizationResponseDtoBuilder withOkpo(String okpo) {
        this.okpo = okpo;
        return this;
    }

    public OrganizationResponseDtoBuilder withOkved(String okved) {
        this.okved = okved;
        return this;
    }

    public OrganizationResponseDtoBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public OrganizationResponseDtoBuilder withShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public OrganizationResponseDtoBuilder withView(String view) {
        this.view = view;
        return this;
    }

    public OrganizationResponseDto build() {
        return new OrganizationResponseDto(comment, contactName, email, id, inn, kpp, longName, ogrn, okpo, okved, phone, shortName, view);
    }
}
