package com.logismiko.docs_auto_fill.services.factories;

import com.logismiko.docs_auto_fill.api.models.requests.OrganizationRequestDto;
import com.logismiko.docs_auto_fill.dao.entities.OrganizationEntity;
import com.logismiko.docs_auto_fill.services.builders.OrganizationEntityBuilder;

import static com.logismiko.docs_auto_fill.api.constants.ApiRoutes.Error.UTILITY_CLASS;

public final class OrganizationEntityFactory {

    private OrganizationEntityFactory() {
        throw new IllegalStateException(UTILITY_CLASS);
    }

    public static OrganizationEntity makeOrganizationEntity(OrganizationRequestDto organizationRequestDto) {
        return OrganizationEntityBuilder.anOrganizationEntity()
                .withComment(organizationRequestDto.comment())
                .withContactName(organizationRequestDto.contactName())
                .withEmail(organizationRequestDto.email())
                .withId(organizationRequestDto.id())
                .withInn(organizationRequestDto.inn())
                .withKpp(organizationRequestDto.kpp())
                .withLongName(organizationRequestDto.longName())
                .withOgrn(organizationRequestDto.ogrn())
                .withOkpo(organizationRequestDto.okpo())
                .withOkved(organizationRequestDto.okved())
                .withPhone(organizationRequestDto.phone())
                .withShortName(organizationRequestDto.shortName())
                .withView(organizationRequestDto.view())
                .build();
    }
}