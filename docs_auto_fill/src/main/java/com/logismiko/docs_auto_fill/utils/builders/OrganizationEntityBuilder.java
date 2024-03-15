package com.logismiko.docs_auto_fill.utils.builders;

import com.logismiko.docs_auto_fill.dao.entities.OrganizationEntity;

/**
 * The type Organization entity builder.
 */
public final class OrganizationEntityBuilder {
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

    private OrganizationEntityBuilder() {
    }

    /**
     * An organization entity organization entity builder.
     *
     * @return the organization entity builder
     */
    public static OrganizationEntityBuilder anOrganizationEntity() {
        return new OrganizationEntityBuilder();
    }

    /**
     * With id organization entity builder.
     *
     * @param id the id
     * @return the organization entity builder
     */
    public OrganizationEntityBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * With view organization entity builder.
     *
     * @param view the view
     * @return the organization entity builder
     */
    public OrganizationEntityBuilder withView(String view) {
        this.view = view;
        return this;
    }

    /**
     * With short name organization entity builder.
     *
     * @param shortName the short name
     * @return the organization entity builder
     */
    public OrganizationEntityBuilder withShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    /**
     * With long name organization entity builder.
     *
     * @param longName the long name
     * @return the organization entity builder
     */
    public OrganizationEntityBuilder withLongName(String longName) {
        this.longName = longName;
        return this;
    }

    /**
     * With inn organization entity builder.
     *
     * @param inn the inn
     * @return the organization entity builder
     */
    public OrganizationEntityBuilder withInn(String inn) {
        this.inn = inn;
        return this;
    }

    /**
     * With kpp organization entity builder.
     *
     * @param kpp the kpp
     * @return the organization entity builder
     */
    public OrganizationEntityBuilder withKpp(String kpp) {
        this.kpp = kpp;
        return this;
    }

    /**
     * With okved organization entity builder.
     *
     * @param okved the okved
     * @return the organization entity builder
     */
    public OrganizationEntityBuilder withOkved(String okved) {
        this.okved = okved;
        return this;
    }

    /**
     * With okpo organization entity builder.
     *
     * @param okpo the okpo
     * @return the organization entity builder
     */
    public OrganizationEntityBuilder withOkpo(String okpo) {
        this.okpo = okpo;
        return this;
    }

    /**
     * With ogrn organization entity builder.
     *
     * @param ogrn the ogrn
     * @return the organization entity builder
     */
    public OrganizationEntityBuilder withOgrn(String ogrn) {
        this.ogrn = ogrn;
        return this;
    }

    /**
     * With email organization entity builder.
     *
     * @param email the email
     * @return the organization entity builder
     */
    public OrganizationEntityBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * With phone organization entity builder.
     *
     * @param phone the phone
     * @return the organization entity builder
     */
    public OrganizationEntityBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * With comment organization entity builder.
     *
     * @param comment the comment
     * @return the organization entity builder
     */
    public OrganizationEntityBuilder withComment(String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * With contact name organization entity builder.
     *
     * @param contactName the contact name
     * @return the organization entity builder
     */
    public OrganizationEntityBuilder withContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    /**
     * Build organization entity.
     *
     * @return the organization entity
     */
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
