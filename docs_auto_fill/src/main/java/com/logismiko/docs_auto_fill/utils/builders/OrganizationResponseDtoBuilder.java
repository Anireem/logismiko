package com.logismiko.docs_auto_fill.utils.builders;

import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;

/**
 * The type Organization response dto builder.
 */
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

    /**
     * An organization response dto organization response dto builder.
     *
     * @return the organization response dto builder
     */
    public static OrganizationResponseDtoBuilder anOrganizationResponseDto() {
        return new OrganizationResponseDtoBuilder();
    }

    /**
     * With comment organization response dto builder.
     *
     * @param comment the comment
     * @return the organization response dto builder
     */
    public OrganizationResponseDtoBuilder withComment(String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * With contact name organization response dto builder.
     *
     * @param contactName the contact name
     * @return the organization response dto builder
     */
    public OrganizationResponseDtoBuilder withContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    /**
     * With email organization response dto builder.
     *
     * @param email the email
     * @return the organization response dto builder
     */
    public OrganizationResponseDtoBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * With id organization response dto builder.
     *
     * @param id the id
     * @return the organization response dto builder
     */
    public OrganizationResponseDtoBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * With inn organization response dto builder.
     *
     * @param inn the inn
     * @return the organization response dto builder
     */
    public OrganizationResponseDtoBuilder withInn(String inn) {
        this.inn = inn;
        return this;
    }

    /**
     * With kpp organization response dto builder.
     *
     * @param kpp the kpp
     * @return the organization response dto builder
     */
    public OrganizationResponseDtoBuilder withKpp(String kpp) {
        this.kpp = kpp;
        return this;
    }

    /**
     * With long name organization response dto builder.
     *
     * @param longName the long name
     * @return the organization response dto builder
     */
    public OrganizationResponseDtoBuilder withLongName(String longName) {
        this.longName = longName;
        return this;
    }

    /**
     * With ogrn organization response dto builder.
     *
     * @param ogrn the ogrn
     * @return the organization response dto builder
     */
    public OrganizationResponseDtoBuilder withOgrn(String ogrn) {
        this.ogrn = ogrn;
        return this;
    }

    /**
     * With okpo organization response dto builder.
     *
     * @param okpo the okpo
     * @return the organization response dto builder
     */
    public OrganizationResponseDtoBuilder withOkpo(String okpo) {
        this.okpo = okpo;
        return this;
    }

    /**
     * With okved organization response dto builder.
     *
     * @param okved the okved
     * @return the organization response dto builder
     */
    public OrganizationResponseDtoBuilder withOkved(String okved) {
        this.okved = okved;
        return this;
    }

    /**
     * With phone organization response dto builder.
     *
     * @param phone the phone
     * @return the organization response dto builder
     */
    public OrganizationResponseDtoBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * With short name organization response dto builder.
     *
     * @param shortName the short name
     * @return the organization response dto builder
     */
    public OrganizationResponseDtoBuilder withShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    /**
     * With view organization response dto builder.
     *
     * @param view the view
     * @return the organization response dto builder
     */
    public OrganizationResponseDtoBuilder withView(String view) {
        this.view = view;
        return this;
    }

    /**
     * Build organization response dto.
     *
     * @return the organization response dto
     */
    public OrganizationResponseDto build() {
        return new OrganizationResponseDto(comment, contactName, email, id, inn, kpp, longName, ogrn, okpo, okved, phone, shortName, view);
    }
}
