/*
 * SavingsAccountRepository.java
 * SavingsAccountRepository Class
 * Author: Rorisang Makgana (230602363)
 * Date: 28th March 2025
 */
package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.SavingsAccount;

import java.util.ArrayList;
import java.util.List;

public class SavingsAccountRepository implements ISavingsAccount{
    private static ISavingsAccount repository;
    private List<SavingsAccount> savingsAccountsList;

    private SavingsAccountRepository(){
        savingsAccountsList = new ArrayList<SavingsAccount>();
    }

    public static ISavingsAccount getInstance(){
        if(repository == null){
            repository = new SavingsAccountRepository();
        }
        return repository;
    }
    @Override
    public SavingsAccount create(SavingsAccount savingsAccount) {
        boolean success = savingsAccountsList.add(savingsAccount);
        if(success){
            return savingsAccount;
        }
        else return null;
    }

    @Override
    public String read(String accountID) {
        for(SavingsAccount savingsAccount: savingsAccountsList){
            return accountID;
        }
        return null;
    }

    @Override
    public SavingsAccount update(SavingsAccount savingsAccount) {
        String accountID = savingsAccount.toString();
    }

    @Override
    public boolean delete(String accountID) {
        String savingsAccountToDelete = read(accountID);
        if(savingsAccountToDelete == null){
            return false;
        }
        return (savingsAccountsList.remove(savingsAccountToDelete));
    }

    @Override
    public List<SavingsAccount> getAll() {
        return savingsAccountsList;
    }

}
