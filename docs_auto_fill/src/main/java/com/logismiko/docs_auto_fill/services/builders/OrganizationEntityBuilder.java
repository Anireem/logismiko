package com.logismiko.docs_auto_fill.services.builders;

import com.logismiko.docs_auto_fill.dao.entities.OrganizationEntity;

public final class OrganizationEntityBuilder {
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

    private OrganizationEntityBuilder() {
    }

    public static OrganizationEntityBuilder anOrganizationEntity() {
        return new OrganizationEntityBuilder();
    }

    public OrganizationEntityBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public OrganizationEntityBuilder withView(String view) {
        this.view = view;
        return this;
    }

    public OrganizationEntityBuilder withShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public OrganizationEntityBuilder withLongName(String longName) {
        this.longName = longName;
        return this;
    }

    public OrganizationEntityBuilder withInn(String inn) {
        this.inn = inn;
        return this;
    }

    public OrganizationEntityBuilder withKpp(Integer kpp) {
        this.kpp = kpp;
        return this;
    }

    public OrganizationEntityBuilder withOkved(String okved) {
        this.okved = okved;
        return this;
    }

    public OrganizationEntityBuilder withOkpo(String okpo) {
        this.okpo = okpo;
        return this;
    }

    public OrganizationEntityBuilder withOgrn(Integer ogrn) {
        this.ogrn = ogrn;
        return this;
    }

    public OrganizationEntityBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public OrganizationEntityBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public OrganizationEntityBuilder withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public OrganizationEntityBuilder withContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public OrganizationEntity build() {
        OrganizationEntity organizationEntity = new OrganizationEntity();
        organizationEntity.setId(id);
        organizationEntity.setView(view);
        organizationEntity.setShortName(shortName);
        organizationEntity.setLongName(longName);
        organizationEntity.setInn(inn);
        organizationEntity.setKpp(kpp);
        organizationEntity.setOkved(okved);
        organizationEntity.setOkpo(okpo);
        organizationEntity.setOgrn(ogrn);
        organizationEntity.setEmail(email);
        organizationEntity.setPhone(phone);
        organizationEntity.setComment(comment);
        organizationEntity.setContactName(contactName);
        return organizationEntity;
    }
}
