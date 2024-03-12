package com.logismiko.docs_auto_fill.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrganizationEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    //<editor-fold desc="Getters and Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public Integer getKpp() {
        return kpp;
    }

    public void setKpp(Integer kpp) {
        this.kpp = kpp;
    }

    public String getOkved() {
        return okved;
    }

    public void setOkved(String okved) {
        this.okved = okved;
    }

    public String getOkpo() {
        return okpo;
    }

    public void setOkpo(String okpo) {
        this.okpo = okpo;
    }

    public Integer getOgrn() {
        return ogrn;
    }

    public void setOgrn(Integer ogrn) {
        this.ogrn = ogrn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    //</editor-fold>
}
