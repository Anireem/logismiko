package com.logismiko.docs_auto_fill.controllers;

import com.logismiko.docs_auto_fill.api.constants.ApiRoutes;
import com.logismiko.docs_auto_fill.api.endpoints.FirmEndpoint;
import com.logismiko.docs_auto_fill.api.models.requests.FirmRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.FirmResponseDto;
import com.logismiko.docs_auto_fill.errors.handlers.ControllerExceptionHandler;
import com.logismiko.docs_auto_fill.services.FirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Represents methods for working with Firms.
 */
@RestController
@RequestMapping(ApiRoutes.Firm.FIRM_CONTEXT_PATH)
public class FirmController
    implements FirmEndpoint, ControllerExceptionHandler {

    /**
     * Service layer for working with Firms.
     */
    private final FirmService firmService;

    /**
     * Constructor, parameters are filled using Dependency Injection.
     * @param firmService Service layer for working with Firms.
     */
    @Autowired
    public FirmController(final FirmService firmService) {
        this.firmService = firmService;
    }

    /**
     * Adds Firm to the database.
     * @param firmRequestDto DTO for creating a Firm.
     * @param ucb Service parameter, filled in automatically,
     * @return ResponseEntity with code 200 (with a link to a new element),
     * or with code 400.
     */
    @PostMapping
    @Override
    public ResponseEntity<Void> addFirm(
        final FirmRequestDto firmRequestDto,
        final UriComponentsBuilder ucb
    ) {
        FirmResponseDto firmResponseDto = firmService.addFirm(firmRequestDto);
        URI location = ucb
            .path(ApiRoutes.Firm.FIRM_CONTEXT_PATH + "/{id}")
            .buildAndExpand(firmResponseDto.id())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    /**
     * Get Firm by ID.
     * @param id Firm ID.
     * @return ResponseEntity with code 200 and body containing the Firm's DTO.
     */
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<FirmResponseDto> getFirm(final Long id) {
        return ResponseEntity.ok(firmService.getFirmById(id));
    }

    /**
     * Returns page of Firms as list of Firm response DTOs.
     * @param pageable consists page number (0-default), size (20-default
     *                 and sort type (no sort - default).
     * @return list of Firm response DTOs.
     */
    @GetMapping
    @Override
    public ResponseEntity<Iterable<FirmResponseDto>> getFirms(
        final Pageable pageable
    ) {
        return ResponseEntity.ok(firmService.getFirms(pageable));
    }

    /**
     * Delete Firm by ID from database.
     * @param id Firm ID.
     * @return ResponseEntity with code 204, without extra content.
     */
    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> deleteFirm(final Long id) {
        firmService.deleteFirm(id);
        return ResponseEntity.noContent().build();
    }
}
