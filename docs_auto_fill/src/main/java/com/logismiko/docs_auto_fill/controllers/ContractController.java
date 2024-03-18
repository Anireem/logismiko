package com.logismiko.docs_auto_fill.controllers;

import com.logismiko.docs_auto_fill.api.constants.ApiRoutes;
import com.logismiko.docs_auto_fill.api.endpoints.ContractEndpoint;
import com.logismiko.docs_auto_fill.api.models.requests.ContractRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.ContractResponseDto;
import com.logismiko.docs_auto_fill.errors.handlers.ControllerExceptionHandler;
import com.logismiko.docs_auto_fill.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Represents methods for working with contracts.
 */
@RestController
@RequestMapping(ApiRoutes.Contract.CONTRACT_CONTEXT_PATH)
public class ContractController implements ContractEndpoint, ControllerExceptionHandler {

    /**
     * Service layer for working with Contracts.
     */
    ContractService contractService;

    /**
     * Constructor, parameters are filled using Dependency Injection.
     * @param contractService Service layer for working with Contracts.
     */
    @Autowired
    public ContractController(final ContractService contractService) {
        this.contractService = contractService;
    }

    /**
     * Adds Contract to the database.
     * @param contractRequestDto DTO for creating Contract.
     * @param ucb Service parameter, filled in automatically,
     * @return ResponseEntity with code 200 (with a link to a new element),
     * or with code 400.
     */
    @PostMapping
    @Override
    public ResponseEntity<Void> addContract(
        final ContractRequestDto contractRequestDto,
        final UriComponentsBuilder ucb
    ) {
        ContractResponseDto contractResponseDto = contractService.addContract(contractRequestDto);
        URI location = ucb
            .path(ApiRoutes.Contract.CONTRACT_CONTEXT_PATH + "/{id}")
            .buildAndExpand(contractResponseDto.id())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    /**
     * Get Contract by ID.
     * @param id Contract ID.
     * @return ResponseEntity with code 200 and body containing the Contracts's DTO.
     */
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ContractResponseDto> getContract(final Long id) {
        return ResponseEntity.ok(contractService.getContractById(id));
    }

    /**
     * Returns page of Contracts as list of Contract response DTOs.
     * @param pageable consists page number (0-default), size (20-default
     *                 and sort type (no sort - default).
     * @return list of Contract response DTOs.
     */
    @GetMapping
    @Override
    public ResponseEntity<Iterable<ContractResponseDto>> getContracts(Pageable pageable) {
        return ResponseEntity.ok(contractService.getContracts(pageable));
    }

    /**
     * Delete contract by ID from database.
     * @param id contract ID.
     * @return ResponseEntity with code 204, without extra content.
     */
    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> deleteContract(Long id) {
        contractService.deleteContract(id);
        return ResponseEntity.noContent().build();
    }
}
