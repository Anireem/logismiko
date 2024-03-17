package com.logismiko.docs_auto_fill.utils.builders;

import com.logismiko.docs_auto_fill.dao.entities.FirmDataEntity;
import com.logismiko.docs_auto_fill.dao.entities.FirmEntity;

import java.util.LinkedHashSet;
import java.util.Set;

public final class FirmEntityBuilder {
    private Long id;
    private String view;
    private String shortName;
    private String longName;
    private String inn;
    private String kpp;
    private String okved;
    private String okpo;
    private String ogrn;
    private String email;
    private String phone;
    private String comment;
    private String contactName;
    private Set<FirmDataEntity> firmDataEntities = new LinkedHashSet<>();

    private FirmEntityBuilder() {
    }

    public static FirmEntityBuilder anFirmEntity() {
        return new FirmEntityBuilder();
    }

    public FirmEntityBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public FirmEntityBuilder withView(String view) {
        this.view = view;
        return this;
    }

    public FirmEntityBuilder withShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public FirmEntityBuilder withLongName(String longName) {
        this.longName = longName;
        return this;
    }

    public FirmEntityBuilder withInn(String inn) {
        this.inn = inn;
        return this;
    }

    public FirmEntityBuilder withKpp(String kpp) {
        this.kpp = kpp;
        return this;
    }

    public FirmEntityBuilder withOkved(String okved) {
        this.okved = okved;
        return this;
    }

    public FirmEntityBuilder withOkpo(String okpo) {
        this.okpo = okpo;
        return this;
    }

    public FirmEntityBuilder withOgrn(String ogrn) {
        this.ogrn = ogrn;
        return this;
    }

    public FirmEntityBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public FirmEntityBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public FirmEntityBuilder withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public FirmEntityBuilder withContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public FirmEntityBuilder withFirmDataEntities(Set<FirmDataEntity> firmDataEntities) {
        this.firmDataEntities = firmDataEntities;
        return this;
    }

    public FirmEntity build() {
        FirmEntity firmEntity = new FirmEntity();
        firmEntity.setId(id);
        firmEntity.setView(view);
        firmEntity.setShortName(shortName);
        firmEntity.setLongName(longName);
        firmEntity.setInn(inn);
        firmEntity.setKpp(kpp);
        firmEntity.setOkved(okved);
        firmEntity.setOkpo(okpo);
        firmEntity.setOgrn(ogrn);
        firmEntity.setEmail(email);
        firmEntity.setPhone(phone);
        firmEntity.setComment(comment);
        firmEntity.setContactName(contactName);
        firmEntity.setFirmDataEntities(firmDataEntities);
        return firmEntity;
    }
}
