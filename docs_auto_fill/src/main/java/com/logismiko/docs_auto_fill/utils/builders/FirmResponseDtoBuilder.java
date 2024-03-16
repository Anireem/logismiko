package com.logismiko.docs_auto_fill.utils.builders;

import com.logismiko.docs_auto_fill.api.models.responses.FirmResponseDto;

/**
 * The type Firm response dto builder.
 */
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

    private FirmResponseDtoBuilder() {
    }

    /**
     * A firm response dto firm response dto builder.
     *
     * @return the firm response dto builder
     */
    public static FirmResponseDtoBuilder anFirmResponseDto() {
        return new FirmResponseDtoBuilder();
    }

    /**
     * With comment firm response dto builder.
     *
     * @param comment the comment
     * @return the firm response dto builder
     */
    public FirmResponseDtoBuilder withComment(String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * With contact name firm response dto builder.
     *
     * @param contactName the contact name
     * @return the firm response dto builder
     */
    public FirmResponseDtoBuilder withContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    /**
     * With email firm response dto builder.
     *
     * @param email the email
     * @return the firm response dto builder
     */
    public FirmResponseDtoBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * With id firm response dto builder.
     *
     * @param id the id
     * @return the firm response dto builder
     */
    public FirmResponseDtoBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * With inn firm response dto builder.
     *
     * @param inn the inn
     * @return the firm response dto builder
     */
    public FirmResponseDtoBuilder withInn(String inn) {
        this.inn = inn;
        return this;
    }

    /**
     * With kpp firm response dto builder.
     *
     * @param kpp the kpp
     * @return the firm response dto builder
     */
    public FirmResponseDtoBuilder withKpp(String kpp) {
        this.kpp = kpp;
        return this;
    }

    /**
     * With long name firm response dto builder.
     *
     * @param longName the long name
     * @return the firm response dto builder
     */
    public FirmResponseDtoBuilder withLongName(String longName) {
        this.longName = longName;
        return this;
    }

    /**
     * With ogrn firm response dto builder.
     *
     * @param ogrn the ogrn
     * @return the firm response dto builder
     */
    public FirmResponseDtoBuilder withOgrn(String ogrn) {
        this.ogrn = ogrn;
        return this;
    }

    /**
     * With okpo firm response dto builder.
     *
     * @param okpo the okpo
     * @return the firm response dto builder
     */
    public FirmResponseDtoBuilder withOkpo(String okpo) {
        this.okpo = okpo;
        return this;
    }

    /**
     * With okved firm response dto builder.
     *
     * @param okved the okved
     * @return the firm response dto builder
     */
    public FirmResponseDtoBuilder withOkved(String okved) {
        this.okved = okved;
        return this;
    }

    /**
     * With phone firm response dto builder.
     *
     * @param phone the phone
     * @return the firm response dto builder
     */
    public FirmResponseDtoBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * With short name firm response dto builder.
     *
     * @param shortName the short name
     * @return the firm response dto builder
     */
    public FirmResponseDtoBuilder withShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    /**
     * With view firm response dto builder.
     *
     * @param view the view
     * @return the firm response dto builder
     */
    public FirmResponseDtoBuilder withView(String view) {
        this.view = view;
        return this;
    }

    /**
     * Build firm response dto.
     *
     * @return the firm response dto
     */
    public FirmResponseDto build() {
        return new FirmResponseDto(comment, contactName, email, id, inn, kpp, longName, ogrn, okpo, okved, phone, shortName, view);
    }
}
