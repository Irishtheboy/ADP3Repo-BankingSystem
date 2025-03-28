package za.co.BankingSystem.Repository;
import za.co.BankingSystem.Domain.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements IAccountRepository{
    private static IAccountRepository repository;
    private List<Account> accountList;

    private AccountRepository(){
        accountList = new ArrayList<Account>();
    }
    public static IRepository getInstance() {
        if (repository == null) {
            repository = new AccountRepository();
        }
        return repository;
    }

    @Override
    public Account create(Account account) {
        boolean success = accountList.add(account);
        if(success){
            return account;
        }
        else return null;
    }

    @Override
    public String read(String accountId) {
        for(Account account: accountList){
            return accountId;
        }
        return null;
    }

    @Override
    public Account update(Account account) {
        Account accountID = account;
    }

    @Override
    public boolean delete(String accountID) {
        String accountToDelete = read(accountID);
        if(accountToDelete == null){
            return false;
        }
        return (accountList.remove(accountToDelete));
    }
    @Override
    public List<Account> getAll() {
        return accountList;
    }
}
