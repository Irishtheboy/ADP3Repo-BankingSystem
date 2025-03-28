package za.co.BankingSystem.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.beans.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StatementRespoitoryTest {
    private static StatementRepository repository = StatementRepository.getRepository();

    private static Statement statement1 = new Statement("S1", "Trasnaction 1", 100.0);
    private static Statement statement2 = new Statement("S2", "Trasnaction 2", 200.0);
    private static Statement statement3 = new Statement("S3", "Trasnaction 3", 300.0);


    @Test
    @Order(1)
    public void testCreateStatement1(){
        Statement created = repository.create(statement1);
        assertNotNull(created);
        assertEquals(statement1.getStatementID(), created.getStatementID());
        System.out.println("Created statement: " + created);
    }
    @Test
    @Order(2)
    public void testCreateStatement2(){
        Statement created = repository.create(statement2);
        assertNotNull(created);
        assertEquals(statement1.getStatementID(), created.getStatementID());
        System.out.println("Created statement: " + created);
    }
    @Test
    @Order(3)
    public void testCreateStatement3(){
        Statement created = repository.create(statement3);
        assertNotNull(created);
        assertEquals(statement1.getStatementID(), created.getStatementID());
        System.out.println("Created statement: " + created);
    }

    @Test
    @Order(4)
    public void testReadStatement(){
        Statement found = repository.read(statement1.getStatementID());
        assertNotNull(found);
        assertEquals(statement1.getStatementID(), found.getStatementID());
        System.out.println("Read statement: " + found);

    }

    @Test
    @Order(5)
    public void testDeleteStatement(){
        boolean deleted = repository.delete(statement2.getStatementID());
        assertTrue(deleted);
        System.out.println("Deleted statement: " + statement2.getStatementID());
    }

    @Test
    @Order(6)
    public void testAllStatements(){
        List<Statement> allStatements = repository.getAll();
        assertFalse(allStatements.isEmpty());
        System.out.println("All statements: " + allStatements);

    }


}
