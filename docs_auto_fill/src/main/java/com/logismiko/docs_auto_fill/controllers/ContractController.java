package com.logismiko.docs_auto_fill.controllers;

import com.logismiko.docs_auto_fill.api.constants.ApiRoutes;
import com.logismiko.docs_auto_fill.api.models.requests.ContractRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.ContractResponseDto;
import com.logismiko.docs_auto_fill.errors.handlers.ControllerExceptionHandler;
import com.logismiko.docs_auto_fill.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Represents methods for working with contracts.
 */
@RestController
@RequestMapping(ApiRoutes.Contract.CONTRACT_CONTEXT_PATH)
public class ContractController implements ControllerExceptionHandler {

    ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping
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

}
