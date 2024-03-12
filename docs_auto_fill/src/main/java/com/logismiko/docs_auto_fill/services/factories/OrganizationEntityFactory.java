package com.logismiko.docs_auto_fill.services.factories;

import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;
import com.logismiko.docs_auto_fill.dao.entities.OrganizationEntity;
import com.logismiko.docs_auto_fill.services.builders.OrganizationEntityBuilder;

public class OrganizationEntityFactory {
    public OrganizationEntity make(OrganizationResponseDto organizationResponseDto) {
        return OrganizationEntityBuilder.anOrganizationEntity()
                .withComment(organizationResponseDto.getComment())
                .withContactName(organizationResponseDto.getContactName())
                .withEmail(organizationResponseDto.getEmail())
                .withId(organizationResponseDto.getId())
                .withInn(organizationResponseDto.getInn())
                .withKpp(organizationResponseDto.getKpp())
                .withLongName(organizationResponseDto.getLongName())
                .withOgrn(organizationResponseDto.getOgrn())
                .withOkpo(organizationResponseDto.getOkpo())
                .withOkved(organizationResponseDto.getOkved())
                .withPhone(organizationResponseDto.getPhone())
                .withShortName(organizationResponseDto.getShortName())
                .withView(organizationResponseDto.getView())
                .build();
    }
}
