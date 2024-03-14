package com.logismiko.docs_auto_fill.controllers;

import com.logismiko.docs_auto_fill.api.endpoints.OrganizationEndpoint;
import com.logismiko.docs_auto_fill.api.models.requests.OrganizationRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;
import com.logismiko.docs_auto_fill.errors.handlers.ControllerExceptionHandler;
import com.logismiko.docs_auto_fill.services.OrganizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static com.logismiko.docs_auto_fill.api.constants.ApiRoutes.Organization.ORGANIZATION_CONTEXT_PATH;

/**
 * Контроллер содержит методы для работы с организациями.
 */
@RestController
@RequestMapping(ORGANIZATION_CONTEXT_PATH)
public class OrganizationController
    implements OrganizationEndpoint, ControllerExceptionHandler {

    /**
     * Слой сервиса для работы с организациями.
     */
    private final OrganizationService organizationService;

    /**
     * Конструктор, параметры заполняются с помощью Dependency Injection.
     * @param organizationService Слой сервиса для работы с организациями.
     */
    @Autowired
    public OrganizationController(
        final OrganizationService organizationService
    ) {
        this.organizationService = organizationService;
    }

    /**
     * Добавить организацию в базу данных.
     * @param organizationRequestDto DTO для создания организации.
     * @param ucb Служебный параметр, заполняется автоматически.
     * @return ResponseEntity с кодом 200 (со ссылкой на новый элемент),
     * либо с кодом 400
     */
    @PostMapping
    @Override
    public ResponseEntity<Void> addOrganization(
        @RequestBody
        @Valid
        final OrganizationRequestDto organizationRequestDto,
        final UriComponentsBuilder ucb
    ) {
        OrganizationResponseDto organizationResponseDto =
            organizationService.addOrganization(organizationRequestDto);
        URI location = ucb
            .path(ORGANIZATION_CONTEXT_PATH + "/{id}")
            .buildAndExpand(organizationResponseDto.id())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    /**
     * Получить организацию по ID.
     * @param id ID организации.
     * @return ResponseEntity с кодом 200 и телом содержащим DTO организации.
     */
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<OrganizationResponseDto> getOrganization(
        @PathVariable(value = "id")
        final Long id
    ) {
        return ResponseEntity.ok(organizationService.getOrganization(id));
    }

    /**
     * Получить список всех организаций, без пагинации.
     * @return Response entity with list of all Organizations in the body.
     */
    @GetMapping
    public
    ResponseEntity<Iterable<OrganizationResponseDto>> getAllOrganizations() {
        return ResponseEntity.ok(organizationService.getAllOrganizations());
    }

    /**
     * Удалить организацию по ID из базы.
     * @param id ID организации.
     * @return Только ResponseEntity с кодом 204, без другого контента.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(
        @PathVariable(value = "id")
        final Long id
    ) {
        organizationService.deleteOrganization(id);
        return ResponseEntity.noContent().build();
    }
}
