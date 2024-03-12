package com.logismiko.docs_auto_fill.controllers;

import com.logismiko.docs_auto_fill.api.models.requests.OrganizationRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;
import com.logismiko.docs_auto_fill.services.OrganizationService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    private OrganizationService organizationService;

    @PostMapping
    public OrganizationResponseDto addOrganization(OrganizationRequestDto organizationRequestDto) {
        return organizationService.addOrganization(organizationRequestDto);
    }

    @GetMapping
    public OrganizationResponseDto getOrganization(@PathVariable(value = "id") Long id) {
        return organizationService.getOrganization(id);
    }

    @GetMapping
    public List<OrganizationResponseDto> getAllOrganizations() {
        return organizationService.getAllOrganizations();
    }

    @DeleteMapping
    public void deleteOrganization(@PathVariable(value = "id") Long id) {
        organizationService.deleteOrganization(id);
    }
}
