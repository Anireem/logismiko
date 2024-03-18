package com.logismiko.docs_auto_fill.services;

import com.logismiko.docs_auto_fill.api.models.requests.ContractRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.ContractResponseDto;
import com.logismiko.docs_auto_fill.dao.entities.ContractEntity;
import com.logismiko.docs_auto_fill.dao.repositories.ContractRepository;
import com.logismiko.docs_auto_fill.utils.factories.ContractEntityFactory;
import com.logismiko.docs_auto_fill.utils.factories.ContractResponseDtoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Represents service layer for working with Contracts.
 */
@Service
public class ContractService {
    /**
     * Repository for working with Contracts.
     */
    private ContractRepository contractRepository;

    /**
     * Constructor, parameters are filled using Dependency Injection.
     * @param contractRepository Repository for working with Contracts.
     */
    @Autowired
    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public ContractResponseDto addContract(ContractRequestDto contractRequestDto) {
        ContractEntity contractEntity = contractRepository.save(
            ContractEntityFactory.make(contractRequestDto)
        );
        return ContractResponseDtoFactory.make(contractEntity);
    }

    /**
     * Retrieves Contract from database by id.
     * @param id Contract ID.
     * @return Found Contract DTO.
     */
    public ContractResponseDto getContractById(Long id) {
        ContractEntity contractEntity = contractRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(NOT_FOUND)
        );
        return ContractResponseDtoFactory.make(contractEntity);
    }

    /**
     * Returns page of Contracts as list of Contract response DTOs.
     * @param pageable consists page number, size and sort type.
     * @return list of Contract response DTOs.
     */
    public List<ContractResponseDto> getContracts(
        final Pageable pageable
    ) {
        return retrieveContracts(pageable)
            .getContent()
            .stream()
            .map(ContractResponseDtoFactory::make)
            .toList();
    }

    /**
     * Remove Contract from database if it exists.
     * @param id ID of the Contract to be deleted.
     */
    public void deleteContract(final Long id) {
        if (contractRepository.existsById(id)) {
            contractRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(NOT_FOUND,
                String.format("Entity: %s not found", 1L));
        }
    }

    //region Private methods
    /**
     * Private method, retrieves a page with Contracts.
     * @param pageable Consists page number, size and sort type.
     * @return Page with Contracts.
     */
    private Page<ContractEntity> retrieveContracts(final Pageable pageable) {
        try {
            return contractRepository.findAll(pageable);
        } catch (PropertyReferenceException propertyReferenceException) {
            throw new ResponseStatusException(
                BAD_REQUEST,
                "Error retrieving contracts",
                propertyReferenceException);
        }
    }
    //endregion
}
