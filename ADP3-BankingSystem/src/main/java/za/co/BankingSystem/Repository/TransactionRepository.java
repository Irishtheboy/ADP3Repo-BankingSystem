package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Transactions;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository implements ITransactionRepository {
    private static TransactionRepository repository = null;
    private List<Transactions> transactionsList;

    private TransactionRepository() {
        transactionsList = new ArrayList<Transactions>();
    }

    public static TransactionRepository getRepository(){
        if(repository==null){
            repository = new TransactionRepository();
        }
        return repository;
    }


    @Override
    public Transactions create(Transactions transactions) {
        boolean success = transactionsList.add(transactions);
        if(success){
            return transactions;
        }
        return null;
    }

    @Override
    public Transactions read(String s) {
        for (Transactions t:transactionsList) {
            if(t.getTransactionID().equals(s))
                return t;
        }
        return null;
    }

    @Override
    public Transactions update(Transactions transactions) {
        String id = transactions.getTransactionID();
        Transactions transactionsOld = read(id);
        if(transactionsOld==null)
            return null;
        boolean success = delete(id);
        if(success){
            if(transactionsList.add(transactions))
                return transactions;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Transactions transactionsToDelete = read(id);
        if(transactionsToDelete==null)
            return false;
        return (transactionsList.remove(transactionsToDelete));

    }
    @Override
    public List<Transactions> getAll() {
        return transactionsList;
    }
}
