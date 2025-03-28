package za.co.BankingSystem.Factory;
import za.co.BankingSystem.Domain.*;
import java.util.Date;

public class AccountFactory {
    public static Account createAccount(
        String accountNumber,
        String accountType,
        double balance,
        Date dateOpened,
        Customer customer
    ){
        //if(){}
        return new Account.Builder()
        .accountNumber(accountNumber)
        .accountType(accountType)
        .balance(balance)
        .dateOpened(dateOpened)
        .customer(customer).build();

    }
}
