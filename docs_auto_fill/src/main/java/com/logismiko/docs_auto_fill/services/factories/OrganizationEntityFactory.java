package com.logismiko.docs_auto_fill.services.factories;

import com.logismiko.docs_auto_fill.api.models.requests.OrganizationRequestDto;
import com.logismiko.docs_auto_fill.dao.entities.OrganizationEntity;
import com.logismiko.docs_auto_fill.services.builders.OrganizationEntityBuilder;

public final class OrganizationEntityFactory {
    public static OrganizationEntity make(OrganizationRequestDto organizationRequestDto) {
        return OrganizationEntityBuilder.anOrganizationEntity()
                .withComment(organizationRequestDto.getComment())
                .withContactName(organizationRequestDto.getContactName())
                .withEmail(organizationRequestDto.getEmail())
                .withId(organizationRequestDto.getId())
                .withInn(organizationRequestDto.getInn())
                .withKpp(organizationRequestDto.getKpp())
                .withLongName(organizationRequestDto.getLongName())
                .withOgrn(organizationRequestDto.getOgrn())
                .withOkpo(organizationRequestDto.getOkpo())
                .withOkved(organizationRequestDto.getOkved())
                .withPhone(organizationRequestDto.getPhone())
                .withShortName(organizationRequestDto.getShortName())
                .withView(organizationRequestDto.getView())
                .build();
    }
}
