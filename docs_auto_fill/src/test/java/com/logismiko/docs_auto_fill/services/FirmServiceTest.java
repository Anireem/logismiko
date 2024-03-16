package com.logismiko.docs_auto_fill.services;

import com.logismiko.docs_auto_fill.api.models.requests.FirmRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.FirmResponseDto;
import com.logismiko.docs_auto_fill.dao.entities.FirmEntity;
import com.logismiko.docs_auto_fill.dao.repositories.FirmRepository;
import com.logismiko.docs_auto_fill.utils.builders.FirmEntityBuilder;
import com.logismiko.docs_auto_fill.utils.builders.FirmRequestDtoBuilder;
import com.logismiko.docs_auto_fill.utils.factories.FirmEntityFactory;
import com.logismiko.docs_auto_fill.utils.factories.FirmResponseDtoFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FirmServiceTest {

    @Mock
    private FirmRepository firmRepository;

    @InjectMocks
    private FirmService firmService;

    @Test
    void addFirm() {
        final FirmRequestDto firmRequestDto = FirmRequestDtoBuilder.anFirmRequestDto()
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
        final FirmEntity firmEntity = FirmEntityFactory.create(firmRequestDto);
        firmEntity.setId(1L);
        when(firmRepository.save(Mockito.any(FirmEntity.class))).thenReturn(firmEntity);

        final FirmResponseDto savedFirmResponseDto = firmService.addFirm(firmRequestDto);

        Assertions.assertThat(savedFirmResponseDto).isNotNull();
        Assertions.assertThat(savedFirmResponseDto.id()).isEqualTo(1L);
        Assertions.assertThat(savedFirmResponseDto.inn()).isEqualTo("7736050003");
    }

    @Test
    void getFirmById() {
        final FirmEntity firmEntity = FirmEntityBuilder.anFirmEntity()
            .withEmail("mail@gazprom.ru")
            .withView("Газпром")
            .build();
        firmEntity.setId(1L);
        when(firmRepository.findById(1L)).thenReturn(Optional.ofNullable(firmEntity));

        FirmResponseDto savedFirm = firmService.getFirmById(1L);

        Assertions.assertThat(savedFirm).isNotNull();
    }

    @Test
    void getFirms() {
        List<FirmResponseDto> firmResponseDtos = Mockito.mock(List.class);
        Page<FirmEntity> page = Mockito.mock(Page.class);
        PageRequest pageable = PageRequest.of(0, 20);
        when(firmRepository.findAll(pageable)).thenReturn(page);
        when(
            page.getContent()
            .stream()
            .map(FirmResponseDtoFactory::create)
            .toList()
        ).thenReturn(firmResponseDtos);

        List<FirmResponseDto> allFirms = firmService.getFirms(pageable);

        Assertions.assertThat(allFirms).isNotNull();
    }

    @Test
    void deleteFirm() {
        final FirmEntity firmEntity = FirmEntityBuilder.anFirmEntity()
            .withEmail("mail@gazprom.ru")
            .withView("Газпром")
            .build();
        firmEntity.setId(1L);
        when(firmRepository.existsById(1L)).thenReturn(true);

        assertAll(() -> firmService.deleteFirm(1L));
    }
}