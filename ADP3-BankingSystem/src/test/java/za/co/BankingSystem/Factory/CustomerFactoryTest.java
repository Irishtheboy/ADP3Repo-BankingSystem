//Naqeebah khan 219099073
package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Customer;
import za.co.BankingSystem.Domain.Account;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerFactoryTest {
    private static List<Account> emptyAccountList = new ArrayList<>();

    private static Customer c1 = CustomerFactory.createCustomer(
            "C001",
            "Naqeebah",
            "Khan",
            "88 Miami Street",
            "naqeebah@gmail.com",
            "072 434 6731",
            emptyAccountList
    );

    private static Customer c2 = CustomerFactory.createCustomer(
            "C002",
            "Franco",
            "Lukhele",
            "42 Barcelona Close",
            "francolukhele@gmail.com",
            "073 964 3861",
            emptyAccountList
    );

    private static Customer c3 = CustomerFactory.createCustomer(
            "C003",
            "Teyana",
            "Raubenheimer",
            "4 Amsterdam Way",
            "RaubenheimerT@gmail.com",
            "062 886 9372",
            emptyAccountList
    );

    private static Customer c4 = CustomerFactory.createCustomer(
            "C004",
            "Rorisang",
            "Makgana",
            "108 Madrid Street",
            "Rorimakgana@gmail.com",
            "063 861 4396",
            emptyAccountList
    );

    private static Customer c5 = CustomerFactory.createCustomer(
            "C005",
            "Seymour",
            "Lawrence",
            "78 London Way",
            "SLawrence@gmail.com",
            "072 618 6729",
            emptyAccountList
    );

    @Test
    @Order(1)
    public void testCreateCustomer1() {
        assertNotNull(c1);
        System.out.println(c1.toString());
    }

    @Test
    @Order(2)
    public void testCreateCustomer2() {
        assertNotNull(c2);
        System.out.println(c2.toString());
    }

    @Test
    @Order(3)
    public void testCreateCustomer3() {
        assertNotNull(c3);
        System.out.println(c3.toString());
    }

    @Test
    @Order(4)
    public void testCreateCustomer4() {
        assertNotNull(c4);
        System.out.println(c4.toString());
    }

    @Test
    @Order(5)
    public void testCreateCustomer5() {
        assertNotNull(c5);
        System.out.println(c5.toString());
    }








}
