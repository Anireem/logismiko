package com.logismiko.docs_auto_fill.dao.repositories;

import com.logismiko.docs_auto_fill.dao.entities.FirmEntity;
import com.logismiko.docs_auto_fill.utils.builders.FirmEntityBuilder;
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
class FirmRepositoryTest {
    private final FirmRepository firmRepository;

    @Autowired
    public FirmRepositoryTest(FirmRepository firmRepository) {
        this.firmRepository = firmRepository;
    }

    @Test
    void SaveFirmEntity_ReturnSameSavedFirmEntity() {
        final FirmEntity firmEntity =
            FirmEntityBuilder.anFirmEntity()
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
                .withView("Газпром").build();

        final FirmEntity savedFirmEntity =
            firmRepository.save(firmEntity);

        Assertions.assertThat(savedFirmEntity).isNotNull();
        Assertions.assertThat(savedFirmEntity.getId()).isPositive();
        Assertions.assertThat(savedFirmEntity.getComment()).isEqualTo("Неплохой клиент");
        Assertions.assertThat(savedFirmEntity.getContactName()).isEqualTo("Миллер Алексей");
        Assertions.assertThat(savedFirmEntity.getEmail()).isEqualTo("mail@gazprom.ru");
        Assertions.assertThat(savedFirmEntity.getInn()).isEqualTo("7736050003");
        Assertions.assertThat(savedFirmEntity.getKpp()).isEqualTo("781401001");
        Assertions.assertThat(savedFirmEntity.getLongName()).isEqualTo("ПУБЛИЧНОЕ АКЦИОНЕРНОЕ ОБЩЕСТВО \"ГАЗПРОМ\"");
        Assertions.assertThat(savedFirmEntity.getOgrn()).isEqualTo("1027700070518");
        Assertions.assertThat(savedFirmEntity.getOkpo()).isEqualTo("00040778");
        Assertions.assertThat(savedFirmEntity.getOkved()).isEqualTo("46.71");
        Assertions.assertThat(savedFirmEntity.getPhone()).isEqualTo("8-495-464-41-12");
        Assertions.assertThat(savedFirmEntity.getShortName()).isEqualTo("ПАО \"Газпром\"");
        Assertions.assertThat(savedFirmEntity.getView()).isEqualTo("Газпром");
    }

    @Test
    void GetAllFirmEntity_ReturnMoreThenOneFirmEntity() {
        final FirmEntity google = FirmEntityBuilder.anFirmEntity()
            .withView("Google")
            .build();
        final FirmEntity apple = FirmEntityBuilder.anFirmEntity()
            .withView("Apple")
            .build();

        firmRepository.save(google);
        firmRepository.save(apple);

        List<FirmEntity> firmEntities = firmRepository.findAll();
        int firmEntitiesSize = firmEntities.size();
        Assertions.assertThat(firmEntities).isNotNull();
        Assertions.assertThat(firmEntitiesSize).isEqualTo(2);
    }

    @Test
    void FindByIdFirmEntity_ReturnFirmEntity() {
        final FirmEntity microsoft =
            FirmEntityBuilder.anFirmEntity()
            .withView("Microsoft")
            .build();

        final FirmEntity microsoftSaved =
            firmRepository.save(microsoft);
        final FirmEntity microsoftFromDatabase =
            firmRepository.findById(microsoftSaved.getId()).get();

        Assertions.assertThat(microsoftFromDatabase).isNotNull();
    }

    @Test
    void UpdateFirmEntity_ReturnFirmEntityNotNull() {
        final FirmEntity amazon =
            FirmEntityBuilder.anFirmEntity()
                .withView("Amazon")
                .withEmail("mail@amazon.ru")
                .build();

        final FirmEntity amazonSaved = firmRepository.save(amazon);
        amazonSaved.setEmail("amazon@bk.ru");
        final FirmEntity amazonUpdated = firmRepository.save(amazonSaved);

        Assertions.assertThat(amazonUpdated.getEmail()).isNotNull();
        Assertions.assertThat(amazonUpdated.getEmail()).isEqualTo("amazon@bk.ru");
    }

    @Test
    void DeleteFirmEntity_ReturnFirmEntityIsEmpty() {
        final FirmEntity intel =
            FirmEntityBuilder.anFirmEntity()
                .withView("Intel")
                .build();

        final FirmEntity intelSaved = firmRepository.save(intel);
        firmRepository.deleteById(intelSaved.getId());
        Optional<FirmEntity> intelReturn = firmRepository.findById(intelSaved.getId());

        Assertions.assertThat(intelReturn).isEmpty();
    }
}
