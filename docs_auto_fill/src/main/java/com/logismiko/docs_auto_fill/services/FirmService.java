package com.logismiko.docs_auto_fill.services;

import com.logismiko.docs_auto_fill.api.models.requests.FirmRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.FirmResponseDto;
import com.logismiko.docs_auto_fill.dao.entities.FirmEntity;
import com.logismiko.docs_auto_fill.dao.repositories.FirmRepository;
import com.logismiko.docs_auto_fill.utils.factories.FirmEntityFactory;
import com.logismiko.docs_auto_fill.utils.factories.FirmResponseDtoFactory;
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
 * Represents service layer for working with Firms.
 */
@Service
public class FirmService {
    /**
     * Repository for working with Firms.
     */
    private FirmRepository firmRepository;

    /**
     * Constructor, parameters are filled using Dependency Injection.
     * @param firmRepository Repository for working with Firms.
     */
    @Autowired
    public FirmService(final FirmRepository firmRepository) {
        this.firmRepository = firmRepository;
    }

    /**
     * Adds Firm to database.
     * @param firmRequestDto DTO for Firm creation.
     * @return DTO of a newly created Firm.
     */
    public FirmResponseDto addFirm(final FirmRequestDto firmRequestDto) {
        FirmEntity firmEntity = FirmEntityFactory.create(firmRequestDto);
        return FirmResponseDtoFactory.create(firmRepository.save(firmEntity));
    }

    /**
     * Retrieves Firm from database by id.
     * @param id Firm ID.
     * @return Found Firm DTO.
     */
    public FirmResponseDto getFirmById(final Long id) {
        FirmEntity firmEntity = firmRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(
                NOT_FOUND,
                String.format("Entity: %s not found", id))
        );
        return FirmResponseDtoFactory.create(firmEntity);
    }

    /**
     * Returns page of Firms as list of Firm response DTOs.
     * @param pageable consists page number, size and sort type.
     * @return list of Firm response DTOs.
     */
    public List<FirmResponseDto> getFirms(
        final Pageable pageable
    ) {
        return retrieveFirms(pageable)
            .getContent()
            .stream()
            .map(FirmResponseDtoFactory::create)
            .toList();
    }

    /**
     * Remove Firm from database if it exists.
     * @param id ID of the Firm to be deleted.
     */
    public void deleteFirm(final Long id) {
        if (firmRepository.existsById(id)) {
            firmRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(NOT_FOUND,
                String.format("Entity: %s not found", 1L));
        }
    }

    //region Private methods
    /**
     * Private method, retrieves a page with Firms.
     * @param pageable Consists page number, size and sort type.
     * @return Page with Firms.
     */
    private Page<FirmEntity> retrieveFirms(final Pageable pageable) {
        try {
            return firmRepository.findAll(pageable);
        } catch (PropertyReferenceException propertyReferenceException) {
            throw new ResponseStatusException(
                BAD_REQUEST,
                "Error retrieving Firms",
                propertyReferenceException);
        }
    }
    //endregion
}
