package com.logismiko.docs_auto_fill.utils.factories;

import com.logismiko.docs_auto_fill.api.models.requests.OrganizationRequestDto;
import com.logismiko.docs_auto_fill.dao.entities.OrganizationEntity;
import com.logismiko.docs_auto_fill.utils.builders.OrganizationEntityBuilder;

/**
 * The type Organization entity factory.
 */
public final class OrganizationEntityFactory {

    private OrganizationEntityFactory() {
    }

    /**
     * Make organization entity organization entity.
     *
     * @param organizationRequestDto the organization request dto
     * @return the organization entity
     */
    public static OrganizationEntity makeOrganizationEntity(OrganizationRequestDto organizationRequestDto) {
        return OrganizationEntityBuilder.anOrganizationEntity()
            .withComment(organizationRequestDto.comment())
            .withContactName(organizationRequestDto.contactName())
            .withEmail(organizationRequestDto.email())
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
