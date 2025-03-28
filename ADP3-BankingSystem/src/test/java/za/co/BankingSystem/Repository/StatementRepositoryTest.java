/*StatementRepositoryTest.java
Statement Repository Test class
Author: Naqeebah Khan(219099073)
date: 28th March 2025*/

package za.co.BankingSystem.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.co.BankingSystem.Domain.Statement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class StatementRepositoryTest {

    private static StatementRepository repository = StatementRepository.getRepository();

    private static Statement statement1 = new Statement.Builder()
            .setStatementID("S1")
            .setCustomerID("C1")
            .setTransaction(List.of("Transaction 1"))
            .setStatementDate("2025-03-28")
            .build();

    private static Statement statement2 = new Statement.Builder()
            .setStatementID("S2")
            .setCustomerID("C2")
            .setTransaction(List.of("Transaction 2"))
            .setStatementDate("2025-03-29")
            .build();

    private static Statement statement3 = new Statement.Builder()
            .setStatementID("S3")
            .setCustomerID("C3")
            .setTransaction(List.of("Transaction 3"))
            .setStatementDate("2025-03-30")
            .build();



    //clean state before each test
    @BeforeEach
    void setUp() {
        repository.clear();
}
    @Test
    void create() {
        Statement created = repository.create(statement1);
        assertNotNull(created);
        assertEquals(statement1.getStatementID(), created.getStatementID());
        System.out.println("Created statement: " + created);
    }

    @Test
    void read() {
        repository.create(statement1);
        Statement read = repository.read(statement1.getStatementID());
        assertNotNull(read);
        assertEquals(statement1.getStatementID(), read.getStatementID());
        System.out.println("Read statement: " + read);
    }

    @Test
    void delete() {
        repository.create(statement2);
        boolean deleted = repository.delete(statement2.getStatementID());
        assertTrue(deleted);

        //to check if it deleted
        Statement deletedStatement = repository.read(statement2.getStatementID());
        assertNull(deletedStatement);
        System.out.println("Deleted statement: " + statement2.getStatementID());
    }



    @Test
    void getAll() {
        repository.create(statement1);
        repository.create(statement2);
        repository.create(statement3);

        List<Statement> allStatements = repository.getAll();
        assertFalse(allStatements.isEmpty());
        assertEquals(3, allStatements.size());  // Ensure exactly 3 statements
        System.out.println("All statements: " + allStatements);
    }
}
