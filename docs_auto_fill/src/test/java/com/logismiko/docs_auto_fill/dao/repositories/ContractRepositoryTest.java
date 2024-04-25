package com.logismiko.docs_auto_fill.dao.repositories;

import com.logismiko.docs_auto_fill.dao.entities.ContractEntity;
import com.logismiko.docs_auto_fill.utils.builders.ContractEntityBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ContractRepositoryTest {
//    private final ContractRepository contractRepository;
//
//    @Autowired
//    public ContractRepositoryTest(ContractRepository contractRepository) {
//        this.contractRepository = contractRepository;
//    }
//
//    @Test
//    public ContractEntity saveContractEntity_ReturnContractEntity() {
//        final ContractEntity contractEntity = ContractEntityBuilder.aContractEntity()
//            .withNumber("nd-60")
//            .withAgreement(LocalDateTime.of(1989, 9, 27, 23, 59, 59))
//            .withStart(LocalDateTime.of(1989, 9, 27, 23, 59, 59))
//            .withExpiration(LocalDateTime.of(1989, 9, 27, 23, 59, 59))
//            .withSum(10000L)
//            .withCurrency("Rub")
//            .withComment("Important contract")
//
//        return null;
//    }
}
