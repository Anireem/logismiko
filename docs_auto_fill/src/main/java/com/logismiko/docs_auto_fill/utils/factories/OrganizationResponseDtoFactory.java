package com.logismiko.docs_auto_fill.utils.factories;

import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;
import com.logismiko.docs_auto_fill.dao.entities.OrganizationEntity;
import com.logismiko.docs_auto_fill.utils.builders.OrganizationResponseDtoBuilder;

/**
 * The type Organization response dto factory.
 */
public final class OrganizationResponseDtoFactory {

    private OrganizationResponseDtoFactory() {
    }

    /**
     * Make organization response dto organization response dto.
     *
     * @param organizationEntity the organization entity
     * @return the organization response dto
     */
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
