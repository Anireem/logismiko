package com.logismiko.docs_auto_fill.dao.repositories;

import com.logismiko.docs_auto_fill.dao.entities.OrganizationEntity;
import com.logismiko.docs_auto_fill.utils.builders.OrganizationEntityBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class OrganizationRepositoryTest {
    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationRepositoryTest(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Test
    void SaveOrganizationEntity_ReturnSavedOrganizationEntity() {
        final OrganizationEntity organizationEntity =
            OrganizationEntityBuilder
                .anOrganizationEntity()
                .withComment("Неплохой клиент")
                .withContactName("Миллер Алексей")
                .withEmail("mail@gazprom.ru")
                .withInn("7736050003")
                .withKpp("781401001")
                .withLongName("ПУБЛИЧНОЕ АКЦИОНЕРНОЕ ОБЩЕСТВО \"ГАЗПРОМ\"")
                .withOgrn("1027700070518")
                .withOkpo("00040778")
                .withOkved("46.71")
                .withPhone("8-495-464-41-12")
                .withShortName("ПАО \"Газпром\"")
                .withView("Газпром")
                .build();

        final OrganizationEntity savedOrganizationEntity =
            organizationRepository.save(organizationEntity);

        Assertions.assertThat(savedOrganizationEntity).isNotNull();
        Assertions.assertThat(savedOrganizationEntity.getId()).isPositive();
    }

    @Test
    void GetAllOrganizationEntity_ReturnMoreThenOneOrganizationEntity() {
        final OrganizationEntity google = OrganizationEntityBuilder.anOrganizationEntity()
            .withView("Google")
            .build();
        final OrganizationEntity apple = OrganizationEntityBuilder.anOrganizationEntity()
            .withView("Apple")
            .build();

        organizationRepository.save(google);
        organizationRepository.save(apple);

        List<OrganizationEntity> organizationEntities = organizationRepository.findAll();
        int organizationEntitiesSize = organizationEntities.size();
        Assertions.assertThat(organizationEntities).isNotNull();
        Assertions.assertThat(organizationEntitiesSize).isEqualTo(2);
    }

    @Test
    void FindByIdOrganizationEntity_ReturnOrganizationEntity() {
        final OrganizationEntity microsoft =
            OrganizationEntityBuilder.anOrganizationEntity()
            .withView("Microsoft")
            .build();

        final OrganizationEntity microsoftSaved =
            organizationRepository.save(microsoft);
        final OrganizationEntity microsoftFromDatabase =
            organizationRepository.findById(microsoftSaved.getId()).get();

        Assertions.assertThat(microsoftFromDatabase).isNotNull();
    }

    @Test
    void UpdateOrganizationEntity_ReturnOrganizationEntityNotNull() {
        final OrganizationEntity amazon =
            OrganizationEntityBuilder.anOrganizationEntity()
                .withView("Amazon")
                .withEmail("mail@amazon.ru")
                .build();

        final OrganizationEntity amazonSaved = organizationRepository.save(amazon);
        amazonSaved.setEmail("amazon@bk.ru");
        final OrganizationEntity amazonUpdated = organizationRepository.save(amazonSaved);

        Assertions.assertThat(amazonUpdated.getEmail()).isNotNull();
        Assertions.assertThat(amazonUpdated.getEmail()).isEqualTo("amazon@bk.ru");
    }

    @Test
    void DeleteOrganizationEntity_ReturnOrganizationEntityIsEmpty() {
        final OrganizationEntity intel =
            OrganizationEntityBuilder.anOrganizationEntity()
                .withView("Intel")
                .build();

        final OrganizationEntity intelSaved = organizationRepository.save(intel);
        organizationRepository.deleteById(intelSaved.getId());
        Optional<OrganizationEntity> intelReturn = organizationRepository.findById(intelSaved.getId());

        Assertions.assertThat(intelReturn).isEmpty();
    }
}
