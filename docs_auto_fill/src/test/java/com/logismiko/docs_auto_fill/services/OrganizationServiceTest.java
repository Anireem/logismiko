package com.logismiko.docs_auto_fill.services;

import com.logismiko.docs_auto_fill.api.models.requests.OrganizationRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;
import com.logismiko.docs_auto_fill.dao.entities.OrganizationEntity;
import com.logismiko.docs_auto_fill.dao.repositories.OrganizationRepository;
import com.logismiko.docs_auto_fill.utils.builders.OrganizationEntityBuilder;
import com.logismiko.docs_auto_fill.utils.builders.OrganizationRequestDtoBuilder;
import com.logismiko.docs_auto_fill.utils.factories.OrganizationEntityFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrganizationServiceTest {

    @Mock
    private OrganizationRepository organizationRepository;

    @InjectMocks
    private OrganizationService organizationService;

    @Test
    void addOrganization() {
        final OrganizationRequestDto organizationRequestDto = OrganizationRequestDtoBuilder.anOrganizationRequestDto()
            .withComment("Неплохой клиент")
            .withContactName("Миллер Алексей")
            .withEmail("mail@gazprom.ru")
            .withInn("7736050003")
            .withKpp("781401001")
            .withLongName("ПУБЛИЧНОЕ АКЦИОНЕРНОЕ ОБЩЕСТВО \"ГАЗПРОМ\"")
            .withOgrn("1027700070518")
            .withOkpo("00040778")
            .withOkved("46.71")
            .withPhone("8-495-464-41-12")
            .withShortName("ПАО \"Газпром\"")
            .withView("Газпром").build();
        final OrganizationEntity organizationEntity = OrganizationEntityFactory.makeOrganizationEntity(organizationRequestDto);
        organizationEntity.setId(1L);
        when(organizationRepository.save(Mockito.any(OrganizationEntity.class))).thenReturn(organizationEntity);

        final OrganizationResponseDto savedOrganizationResponseDto = organizationService.addOrganization(organizationRequestDto);

        Assertions.assertThat(savedOrganizationResponseDto).isNotNull();
        Assertions.assertThat(savedOrganizationResponseDto.id()).isEqualTo(1L);
        Assertions.assertThat(savedOrganizationResponseDto.inn()).isEqualTo("7736050003");
    }

    @Test
    void getOrganizationById() {
        final OrganizationEntity organizationEntity = OrganizationEntityBuilder.anOrganizationEntity()
            .withEmail("mail@gazprom.ru")
            .withView("Газпром")
            .build();
        organizationEntity.setId(1L);
        when(organizationRepository.findById(1L)).thenReturn(Optional.ofNullable(organizationEntity));

        OrganizationResponseDto savedOrganization = organizationService.getOrganizationById(1L);

        Assertions.assertThat(savedOrganization).isNotNull();
    }

    @Test
    void getAllOrganizations() {
        List<OrganizationEntity> organizationEntities = Mockito.mock(List.class);
        when(organizationRepository.findAll()).thenReturn(organizationEntities);

        List<OrganizationResponseDto> allOrganizations = organizationService.getAllOrganizations();

        Assertions.assertThat(allOrganizations).isNotNull();
    }

    @Test
    void deleteOrganization() {
        final OrganizationEntity organizationEntity = OrganizationEntityBuilder.anOrganizationEntity()
            .withEmail("mail@gazprom.ru")
            .withView("Газпром")
            .build();
        organizationEntity.setId(1L);
        when(organizationRepository.existsById(1L)).thenReturn(true);

        assertAll(() -> organizationService.deleteOrganization(1L));
    }
}