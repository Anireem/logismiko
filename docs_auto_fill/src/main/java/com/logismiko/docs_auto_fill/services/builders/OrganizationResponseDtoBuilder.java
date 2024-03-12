package com.logismiko.docs_auto_fill.services.builders;

import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;

public final class OrganizationResponseDtoBuilder {
    private Long id;
    private String view;
    private String shortName;
    private String longName;
    private String inn;
    private Integer kpp;
    private String okved;
    private String okpo;
    private Integer ogrn;
    private String email;
    private String phone;
    private String comment;
    private String contactName;

    private OrganizationResponseDtoBuilder() {
    }

    public static OrganizationResponseDtoBuilder anOrganizationResponseDto() {
        return new OrganizationResponseDtoBuilder();
    }

    public OrganizationResponseDtoBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public OrganizationResponseDtoBuilder withView(String view) {
        this.view = view;
        return this;
    }

    public OrganizationResponseDtoBuilder withShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public OrganizationResponseDtoBuilder withLongName(String longName) {
        this.longName = longName;
        return this;
    }

    public OrganizationResponseDtoBuilder withInn(String inn) {
        this.inn = inn;
        return this;
    }

    public OrganizationResponseDtoBuilder withKpp(Integer kpp) {
        this.kpp = kpp;
        return this;
    }

    public OrganizationResponseDtoBuilder withOkved(String okved) {
        this.okved = okved;
        return this;
    }

    public OrganizationResponseDtoBuilder withOkpo(String okpo) {
        this.okpo = okpo;
        return this;
    }

    public OrganizationResponseDtoBuilder withOgrn(Integer ogrn) {
        this.ogrn = ogrn;
        return this;
    }

    public OrganizationResponseDtoBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public OrganizationResponseDtoBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public OrganizationResponseDtoBuilder withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public OrganizationResponseDtoBuilder withContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public OrganizationResponseDto build() {
        OrganizationResponseDto organizationResponseDto = new OrganizationResponseDto();
        organizationResponseDto.setId(id);
        organizationResponseDto.setView(view);
        organizationResponseDto.setShortName(shortName);
        organizationResponseDto.setLongName(longName);
        organizationResponseDto.setInn(inn);
        organizationResponseDto.setKpp(kpp);
        organizationResponseDto.setOkved(okved);
        organizationResponseDto.setOkpo(okpo);
        organizationResponseDto.setOgrn(ogrn);
        organizationResponseDto.setEmail(email);
        organizationResponseDto.setPhone(phone);
        organizationResponseDto.setComment(comment);
        organizationResponseDto.setContactName(contactName);
        return organizationResponseDto;
    }
}
