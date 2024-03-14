package com.logismiko.docs_auto_fill.dao.repositories;

import com.logismiko.docs_auto_fill.dao.entities.OrganizationEntity;
import com.logismiko.docs_auto_fill.utils.builders.OrganizationEntityBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class OrganizationRepositoryTest {
    private OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationRepositoryTest(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Test
    void OrganizationRepository_Save_ReturnSavedOrganization() {
        //Arrange
        final OrganizationEntity organizationEntity =
            OrganizationEntityBuilder
                .anOrganizationEntity()
                .withComment("Не приоритетный клиент")
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
        //Act
        final OrganizationEntity savedOrganizationEntity =
            organizationRepository.save(organizationEntity);
        //Assert
        Assertions.assertThat(savedOrganizationEntity).isNotNull();
        Assertions.assertThat(savedOrganizationEntity.getId()).isGreaterThan(0);
    }
}
