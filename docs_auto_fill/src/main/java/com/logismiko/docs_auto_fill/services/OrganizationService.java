package com.logismiko.docs_auto_fill.services;

import com.logismiko.docs_auto_fill.api.models.requests.OrganizationRequestDto;
import com.logismiko.docs_auto_fill.api.models.responses.OrganizationResponseDto;
import com.logismiko.docs_auto_fill.dao.entities.OrganizationEntity;
import com.logismiko.docs_auto_fill.dao.repositories.OrganizationRepository;
import com.logismiko.docs_auto_fill.utils.factories.OrganizationEntityFactory;
import com.logismiko.docs_auto_fill.utils.factories.OrganizationResponseDtoFactory;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Представляет сервисный слой для работы с организациями.
 */
@Service
public class OrganizationService {

    OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(
        OrganizationRepository organizationRepository
    ) {
        this.organizationRepository = organizationRepository;
    }

    /**
     * Добавляет организацию в базу данных.
     * @param organizationRequestDto DTO для создания организации.
     * @return DTO вновь созданной организации.
     */
    public OrganizationResponseDto addOrganization(
        final OrganizationRequestDto organizationRequestDto
    ) {
        OrganizationEntity organizationEntity = OrganizationEntityFactory
            .makeOrganizationEntity(organizationRequestDto);
        return OrganizationResponseDtoFactory.makeOrganizationResponseDto(
            organizationRepository.save(organizationEntity)
        );
    }

    /**
     * Извлекает организацию из базы данных по ID.
     * @param id ID организации.
     * @return DTO найденной организации.
     */
    public OrganizationResponseDto getOrganization(final Long id) {
        return OrganizationResponseDtoFactory.makeOrganizationResponseDto(
            organizationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                    NOT_FOUND, String.format("Entity: %s not found", 1L)
                )
            )
        );
    }

    /**
     * Извлекает весь список организаций из базы данных.
     * @return список из DTO организаций.
     */
    public List<OrganizationResponseDto> getAllOrganizations() {
        return organizationRepository.findAll()
            .stream()
            .map(
                OrganizationResponseDtoFactory::makeOrganizationResponseDto
            )
            .toList();
    }

    /**
     * Удяляет организацию из базы, если она существует.
     * @param id ID подлежащей удалению организации.
     */
    public void deleteOrganization(final Long id) {
        if (organizationRepository.existsById(id)) {
            organizationRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                NOT_FOUND,
                String.format("Entity: %s not found", 1L)
            );
        }
    }
}
