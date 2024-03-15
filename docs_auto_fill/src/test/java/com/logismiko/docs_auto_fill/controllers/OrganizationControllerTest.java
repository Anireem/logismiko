package com.logismiko.docs_auto_fill.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logismiko.docs_auto_fill.api.models.requests.OrganizationRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;
import com.logismiko.docs_auto_fill.dao.entities.OrganizationEntity;
import com.logismiko.docs_auto_fill.services.OrganizationService;
import com.logismiko.docs_auto_fill.utils.builders.OrganizationRequestDtoBuilder;
import com.logismiko.docs_auto_fill.utils.factories.OrganizationEntityFactory;
import com.logismiko.docs_auto_fill.utils.factories.OrganizationResponseDtoFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

@WebMvcTest(controllers = OrganizationController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
// TODO: 3/15/2024 сделать правильный наименования методов
class OrganizationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrganizationService organizationService;

    @Autowired
    private ObjectMapper objectMapper;

    private OrganizationRequestDto organizationRequestDto;
    
    private OrganizationEntity organizationEntity1;
    private OrganizationEntity organizationEntity2;
    
    private OrganizationResponseDto organizationResponseDto1;
    private OrganizationResponseDto organizationResponseDto2;
    
    private List<OrganizationResponseDto> organizationResponseDtoList;

    @BeforeEach
    public void init() {
        organizationRequestDto = OrganizationRequestDtoBuilder.anOrganizationRequestDto()
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
        organizationEntity1 = OrganizationEntityFactory.makeOrganizationEntity(organizationRequestDto);
        organizationEntity2 = OrganizationEntityFactory.makeOrganizationEntity(organizationRequestDto);
        
        organizationEntity1.setId(1L);
        organizationEntity2.setId(2L);
        organizationEntity2.setEmail("mail@gazprom.ru");
        
        organizationResponseDto1 = OrganizationResponseDtoFactory.makeOrganizationResponseDto(organizationEntity1);
        organizationResponseDto2 = OrganizationResponseDtoFactory.makeOrganizationResponseDto(organizationEntity2);
        
        organizationResponseDtoList = new ArrayList<OrganizationResponseDto>();
        organizationResponseDtoList.add(organizationResponseDto1);
        organizationResponseDtoList.add(organizationResponseDto2);
    }

    @Test
    void addOrganization() throws Exception {
        when(organizationService.addOrganization(Mockito.any(OrganizationRequestDto.class))).thenReturn(organizationResponseDto1);
        ResultActions response = mockMvc.perform(post("/api/organizations")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(organizationRequestDto)));
        response
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isCreated());
        // TODO: 3/15/2024 добавить проверку url вновь созданной организации, гет запросом к ней
    }

    @Test
    void getOrganizationById() throws Exception {
        Long organizationId = 1L;
        when(organizationService.getOrganizationById(organizationId)).thenReturn(organizationResponseDto1);

        ResultActions response = mockMvc.perform(get("/api/organizations/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(organizationResponseDto1))
        );

        response
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

    @Test
    void getAllOrganizations() throws Exception {
        when(organizationService.getAllOrganizations()).thenReturn(organizationResponseDtoList);
        ResultActions response = mockMvc.perform(get("/api/organizations")
            .contentType(MediaType.APPLICATION_JSON)
        );

        response.andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.[0].email").value("gazprom@mail.ru"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[1].email").value("mail@gazprom.ru"));
    }

    @Test
    void deleteOrganization() throws Exception {
        Long organizationId = 1L;
        doNothing().when(organizationService).deleteOrganization(organizationId);

        ResultActions response = mockMvc.perform(delete("/api/organizations/1")
            .contentType(MediaType.APPLICATION_JSON)
        );

        response.andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}