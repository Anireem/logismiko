package com.logismiko.docs_auto_fill.controllers;

import com.logismiko.docs_auto_fill.api.models.requests.OrganizationRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;
import com.logismiko.docs_auto_fill.services.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(
        name = "Endpoint для работы с организациями",
        description = "REST API для сохранения и извлечения данных по организациям"
)
@RestController
@RequestMapping("/api/organizations")
public record OrganizationController(@Autowired OrganizationService organizationService) {

    @Operation(
            summary = "Добавляет организацию в базу данных"
    )
    @PostMapping
    public OrganizationResponseDto addOrganization(OrganizationRequestDto organizationRequestDto) {
        return organizationService.addOrganization(organizationRequestDto);
    }

    @GetMapping("/{id}")
    public OrganizationResponseDto getOrganization(@PathVariable(value = "id") Long id) {
        return organizationService.getOrganization(id);
    }

    @GetMapping
    public List<OrganizationResponseDto> getAllOrganizations() {
        return organizationService.getAllOrganizations();
    }

    @DeleteMapping("/{id}")
    public void deleteOrganization(@PathVariable(value = "id") Long id) {
        organizationService.deleteOrganization(id);
    }
}
