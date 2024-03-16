package com.logismiko.docs_auto_fill.utils.builders;

import com.logismiko.docs_auto_fill.dao.entities.FirmEntity;

/**
 * The type Firm entity builder.
 */
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

    private FirmEntityBuilder() {
    }

    /**
     * A firm entity firm entity builder.
     *
     * @return the firm entity builder
     */
    public static FirmEntityBuilder anFirmEntity() {
        return new FirmEntityBuilder();
    }

    /**
     * With id firm entity builder.
     *
     * @param id the id
     * @return the firm entity builder
     */
    public FirmEntityBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * With view firm entity builder.
     *
     * @param view the view
     * @return the firm entity builder
     */
    public FirmEntityBuilder withView(String view) {
        this.view = view;
        return this;
    }

    /**
     * With short name firm entity builder.
     *
     * @param shortName the short name
     * @return the firm entity builder
     */
    public FirmEntityBuilder withShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    /**
     * With long name firm entity builder.
     *
     * @param longName the long name
     * @return the firm entity builder
     */
    public FirmEntityBuilder withLongName(String longName) {
        this.longName = longName;
        return this;
    }

    /**
     * With inn firm entity builder.
     *
     * @param inn the inn
     * @return the firm entity builder
     */
    public FirmEntityBuilder withInn(String inn) {
        this.inn = inn;
        return this;
    }

    /**
     * With kpp firm entity builder.
     *
     * @param kpp the kpp
     * @return the firm entity builder
     */
    public FirmEntityBuilder withKpp(String kpp) {
        this.kpp = kpp;
        return this;
    }

    /**
     * With okved firm entity builder.
     *
     * @param okved the okved
     * @return the firm entity builder
     */
    public FirmEntityBuilder withOkved(String okved) {
        this.okved = okved;
        return this;
    }

    /**
     * With okpo firm entity builder.
     *
     * @param okpo the okpo
     * @return the firm entity builder
     */
    public FirmEntityBuilder withOkpo(String okpo) {
        this.okpo = okpo;
        return this;
    }

    /**
     * With ogrn firm entity builder.
     *
     * @param ogrn the ogrn
     * @return the firm entity builder
     */
    public FirmEntityBuilder withOgrn(String ogrn) {
        this.ogrn = ogrn;
        return this;
    }

    /**
     * With email firm entity builder.
     *
     * @param email the email
     * @return the firm entity builder
     */
    public FirmEntityBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * With phone firm entity builder.
     *
     * @param phone the phone
     * @return the firm entity builder
     */
    public FirmEntityBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * With comment firm entity builder.
     *
     * @param comment the comment
     * @return the firm entity builder
     */
    public FirmEntityBuilder withComment(String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * With contact name firm entity builder.
     *
     * @param contactName the contact name
     * @return the firm entity builder
     */
    public FirmEntityBuilder withContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    /**
     * Build firm entity.
     *
     * @return the firm entity
     */
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
        return firmEntity;
    }
}
