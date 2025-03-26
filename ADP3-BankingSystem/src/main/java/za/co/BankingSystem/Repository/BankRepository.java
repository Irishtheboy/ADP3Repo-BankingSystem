package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Bank;

import java.util.ArrayList;
import java.util.List;

public class BankRepository  implements IBankRepository{

    private static BankRepository repository = null;
    private List<Bank> bankList;

    private BankRepository() {
        bankList = new ArrayList<>();
    }

    public static BankRepository getRepository() {
        if (repository == null) {
            repository = new BankRepository();
        }
        return repository;
    }

    @Override
    public Bank create(Bank bank) {
        boolean success = bankList.add(bank);
        if (success) {
            return bank;
        }
        return null;
    }

    @Override
    public Bank read(String id) {
        for (Bank b : bankList) {
          if (b.getBankID().equals(id))
               return b;
        }
        return null;
    }

    @Override
    public Bank update(Bank bank) {
        String id = bank.getBankID();
        Bank bankOld = read(id);
        if (bankOld ==null)
            return null;

        boolean success = delete(id);
        if (success) {
            if (bankList.add(bank))
                return bank;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Bank bankToDelete = read(id);
        if (bankToDelete == null)
            return false;
        return bankList.remove(bankToDelete);
    }

    @Override
    public List<Bank> findAll() {
        return bankList;
    }
}
