package com.logismiko.docs_auto_fill.api.models.responses;

import jakarta.persistence.Entity;

@Entity
public class OrganizationResponseDto {
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
}
