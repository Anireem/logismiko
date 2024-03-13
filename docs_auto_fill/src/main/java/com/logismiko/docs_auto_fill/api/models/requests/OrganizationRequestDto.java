package com.logismiko.docs_auto_fill.api.models.requests;

public record OrganizationRequestDto(
        String comment,
        String contactName,
        String email,
        Long id,
        String inn,
        Integer kpp,
        String longName,
        Integer ogrn,
        String okpo,
        String okved,
        String phone,
        String shortName,
        String view
) {

}
