package com.logismiko.docs_auto_fill.dao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * Represents Entity to store the organization in database.
 */
@Entity
public class OrganizationEntity {
    private String comment;
    private String contactName;
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    //region Getters and Setters

    /**
     * Gets comment.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets comment.
     *
     * @param comment the comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets contact name.
     *
     * @return the contact name
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Sets contact name.
     *
     * @param contactName the contact name
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets inn.
     *
     * @return the inn
     */
    public String getInn() {
        return inn;
    }

    /**
     * Sets inn.
     *
     * @param inn the inn
     */
    public void setInn(String inn) {
        this.inn = inn;
    }

    /**
     * Gets kpp.
     *
     * @return the kpp
     */
    public String getKpp() {
        return kpp;
    }

    /**
     * Sets kpp.
     *
     * @param kpp the kpp
     */
    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    /**
     * Gets long name.
     *
     * @return the long name
     */
    public String getLongName() {
        return longName;
    }

    /**
     * Sets long name.
     *
     * @param longName the long name
     */
    public void setLongName(String longName) {
        this.longName = longName;
    }

    /**
     * Gets ogrn.
     *
     * @return the ogrn
     */
    public String getOgrn() {
        return ogrn;
    }

    /**
     * Sets ogrn.
     *
     * @param ogrn the ogrn
     */
    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    /**
     * Gets okpo.
     *
     * @return the okpo
     */
    public String getOkpo() {
        return okpo;
    }

    /**
     * Sets okpo.
     *
     * @param okpo the okpo
     */
    public void setOkpo(String okpo) {
        this.okpo = okpo;
    }

    /**
     * Gets okved.
     *
     * @return the okved
     */
    public String getOkved() {
        return okved;
    }

    /**
     * Sets okved.
     *
     * @param okved the okved
     */
    public void setOkved(String okved) {
        this.okved = okved;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets short name.
     *
     * @return the short name
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Sets short name.
     *
     * @param shortName the short name
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * Gets view.
     *
     * @return the view
     */
    public String getView() {
        return view;
    }

    /**
     * Sets view.
     *
     * @param view the view
     */
    public void setView(String view) {
        this.view = view;
    }

    //endregion
}
