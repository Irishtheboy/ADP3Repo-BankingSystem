/*CheckingAccountRepository.java
  CheckingAccountRepository Class
  Author: Teyana Raubenheimer (230237622)
  Date: 18 March 2025
 */

package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Bank;
import za.co.BankingSystem.Domain.CheckingAccount;

import java.util.ArrayList;
import java.util.List;

public class CheckingAccountRepository implements ICheckingAcccountRepository {

    private static CheckingAccountRepository repository = null;
    private List<CheckingAccount> checkingAccountList;

    private CheckingAccountRepository() {
        checkingAccountList = new ArrayList<>();
    }

    public static CheckingAccountRepository getRepository() {
        if (repository == null) {
            repository = new CheckingAccountRepository();
        }
        return repository;
    }

    @Override
    public CheckingAccount create(CheckingAccount checkingAccount) {
        boolean success = checkingAccountList.add(checkingAccount);
        if (success) {
            return checkingAccount;
        }
        return null;
    }

    @Override
    public CheckingAccount read(String id) {
        for (CheckingAccount c : checkingAccountList) {
            if (c.getCheckingAccountID().equals(id))
                return c;
        }
        return null;
    }

    @Override
    public CheckingAccount update(CheckingAccount checkingAccount) {
        String id = checkingAccount.getCheckingAccountID();
        CheckingAccount checkingAccountOld = read(id);
        if (checkingAccountOld ==null)
            return null;

        boolean success = delete(id);
        if (success) {
            if (checkingAccountList.add(checkingAccount))
                return checkingAccount;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        CheckingAccount checkingAccountToDelete = read(id);
        if (checkingAccountToDelete == null)
            return false;
        return checkingAccountList.remove(checkingAccountToDelete);
    }

    @Override
    public List<CheckingAccount> findAll() {
        return checkingAccountList;
    }

}
