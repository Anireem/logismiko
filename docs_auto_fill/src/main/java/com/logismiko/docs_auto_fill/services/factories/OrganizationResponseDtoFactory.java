package com.logismiko.docs_auto_fill.services.factories;

import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;
import com.logismiko.docs_auto_fill.dao.entities.OrganizationEntity;
import com.logismiko.docs_auto_fill.services.builders.OrganizationResponseDtoBuilder;

import static com.logismiko.docs_auto_fill.api.constants.ApiRoutes.Error.UTILITY_CLASS;

public final class OrganizationResponseDtoFactory {

    private OrganizationResponseDtoFactory() {
        throw new IllegalStateException(UTILITY_CLASS);
    }

    public static OrganizationResponseDto makeOrganizationResponseDto(OrganizationEntity organizationEntity) {
        return OrganizationResponseDtoBuilder.anOrganizationResponseDto()
                .withComment(organizationEntity.getComment())
                .withContactName(organizationEntity.getContactName())
                .withEmail(organizationEntity.getEmail())
                .withId(organizationEntity.getId())
                .withInn(organizationEntity.getInn())
                .withKpp(organizationEntity.getKpp())
                .withLongName(organizationEntity.getLongName())
                .withOgrn(organizationEntity.getOgrn())
                .withOkpo(organizationEntity.getOkpo())
                .withOkved(organizationEntity.getOkved())
                .withPhone(organizationEntity.getPhone())
                .withShortName(organizationEntity.getShortName())
                .withView(organizationEntity.getView())
                .build();
    }
}
