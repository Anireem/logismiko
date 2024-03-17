package com.logismiko.docs_auto_fill.controllers;

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

import static com.logismiko.docs_auto_fill.api.constants.ApiRoutes.Firm.ORGANIZATION_CONTEXT_PATH;

/**
 * Represents methods for working with firms.
 */
@RestController
@RequestMapping(ORGANIZATION_CONTEXT_PATH)
public class FirmController
    implements FirmEndpoint, ControllerExceptionHandler {

    /**
     * Service layer for working with firms.
     */
    private final FirmService firmService;

    /**
     * Constructor, parameters are filled using Dependency Injection.
     * @param firmService Service layer for working with firms.
     */
    @Autowired
    public FirmController(final FirmService firmService) {
        this.firmService = firmService;
    }

    /**
     * Adds firm to the database.
     * @param firmRequestDto DTO for creating a firm.
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
            .path(ORGANIZATION_CONTEXT_PATH + "/{id}")
            .buildAndExpand(firmResponseDto.id())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    /**
     * Get firm by ID.
     * @param id Firm ID.
     * @return ResponseEntity with code 200 and body containing the firm's DTO.
     */
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<FirmResponseDto> getFirm(final Long id) {
        return ResponseEntity.ok(firmService.getFirmById(id));
    }

    /**
     * Returns page of firms as list of firm response DTOs.
     * @param pageable consists page number (0-default), size (20-default
     *                 and sort type (no sort - default).
     * @return list of firm response DTOs.
     */
    @GetMapping
    @Override
    public ResponseEntity<Iterable<FirmResponseDto>> getFirms(
        final Pageable pageable
    ) {
        return ResponseEntity.ok(firmService.getFirms(pageable));
    }

    /**
     * Delete firm by ID from database.
     * @param id firm ID.
     * @return ResponseEntity with code 204, without extra content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFirm(final Long id) {
        firmService.deleteFirm(id);
        return ResponseEntity.noContent().build();
    }
}
