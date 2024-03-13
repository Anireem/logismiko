package com.logismiko.docs_auto_fill.controllers;

import com.logismiko.docs_auto_fill.api.OrganizationEnpoint;
import com.logismiko.docs_auto_fill.api.models.requests.OrganizationRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;
import com.logismiko.docs_auto_fill.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/api/organizations")
public record OrganizationController(@Autowired OrganizationService organizationService) implements OrganizationEnpoint {

    @PostMapping
    @Override
    public ResponseEntity<Void> addOrganization(@RequestBody OrganizationRequestDto organizationRequestDto, UriComponentsBuilder ucb) {
        OrganizationResponseDto organizationResponseDto = organizationService.addOrganization(organizationRequestDto);
        URI location = ucb
                .path("/api/organizations/{id}")
                .buildAndExpand(organizationResponseDto.id())
                .toUri();
        ResponseEntity<URI> build = ResponseEntity.created(location).build();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<OrganizationResponseDto> getOrganization(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(organizationService.getOrganization(id));
    }

    @GetMapping
    public ResponseEntity<Iterable<OrganizationResponseDto>> getAllOrganizations() {
        return ResponseEntity.ok(organizationService.getAllOrganizations());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable(value = "id") Long id) {
        organizationService.deleteOrganization(id);
        return ResponseEntity.noContent().build();
    }
}
