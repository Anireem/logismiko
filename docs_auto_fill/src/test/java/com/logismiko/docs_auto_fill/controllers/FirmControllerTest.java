package com.logismiko.docs_auto_fill.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logismiko.docs_auto_fill.api.models.requests.FirmRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.FirmResponseDto;
import com.logismiko.docs_auto_fill.dao.entities.FirmEntity;
import com.logismiko.docs_auto_fill.services.FirmService;
import com.logismiko.docs_auto_fill.utils.builders.FirmRequestDtoBuilder;
import com.logismiko.docs_auto_fill.utils.factories.FirmEntityFactory;
import com.logismiko.docs_auto_fill.utils.factories.FirmResponseDtoFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(controllers = FirmController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
// TODO: 3/15/2024 сделать правильный наименования методов
class FirmControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FirmService firmService;

    @Mock
    private Pageable pageable;

    @Autowired
    private ObjectMapper objectMapper;

    private FirmRequestDto firmRequestDto;
    
    private FirmEntity firmEntity1;
    private FirmEntity firmEntity2;
    
    private FirmResponseDto firmResponseDto1;
    private FirmResponseDto firmResponseDto2;
    
    private List<FirmResponseDto> firmResponseDtoList;

    @BeforeEach
    public void init() {
        firmRequestDto = FirmRequestDtoBuilder.anFirmRequestDto()
            .withComment("Неплохой клиент")
            .withContactName("Миллер Алексей")
            .withEmail("gazprom@mail.ru")
            .withInn("7736050003")
            .withKpp("781401001")
            .withLongName("ПУБЛИЧНОЕ АКЦИОНЕРНОЕ ОБЩЕСТВО \"ГАЗПРОМ\"")
            .withOgrn("1027700070518")
            .withOkpo("00040778")
            .withOkved("46.71")
            .withPhone("8-495-464-41-12")
            .withShortName("ПАО \"Газпром\"")
            .withView("Газпром").build();
        firmEntity1 = FirmEntityFactory.create(firmRequestDto);
        firmEntity2 = FirmEntityFactory.create(firmRequestDto);
        
        firmEntity1.setId(1L);
        firmEntity2.setId(2L);
        firmEntity2.setEmail("mail@gazprom.ru");
        
        firmResponseDto1 = FirmResponseDtoFactory.create(firmEntity1);
        firmResponseDto2 = FirmResponseDtoFactory.create(firmEntity2);
        
        firmResponseDtoList = new ArrayList<FirmResponseDto>();
        firmResponseDtoList.add(firmResponseDto1);
        firmResponseDtoList.add(firmResponseDto2);
    }

    @Test
    void addFirm() throws Exception {
        when(firmService.addFirm(Mockito.any(FirmRequestDto.class))).thenReturn(firmResponseDto1);
        ResultActions response = mockMvc.perform(post("/api/firms")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(firmRequestDto)));
        response
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isCreated());
        // TODO: 3/15/2024 добавить проверку url вновь созданной организации, гет запросом к ней
    }

    @Test
    void getFirmById() throws Exception {
        Long firmId = 1L;
        when(firmService.getFirmById(firmId)).thenReturn(firmResponseDto1);

        ResultActions response = mockMvc.perform(get("/api/firms/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(firmResponseDto1))
        );

        response
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

    @Test
    void getAllFirms() throws Exception {
        PageRequest pageable = PageRequest.of(0, 20);
        when(firmService.getFirms(pageable)).thenReturn(firmResponseDtoList);
        ResultActions response = mockMvc.perform(get("/api/firms")
            .contentType(MediaType.APPLICATION_JSON)
        );

        response.andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.jsonPath("$.[0].email").value("gazprom@mail.ru"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[1].email").value("mail@gazprom.ru"));
    }

    @Test
    void deleteFirm() throws Exception {
        Long firmId = 1L;
        doNothing().when(firmService).deleteFirm(firmId);

        ResultActions response = mockMvc.perform(delete("/api/firms/1")
            .contentType(MediaType.APPLICATION_JSON)
        );

        response.andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}