/*StatementRepository.java
Statement Repository class
Author: Naqeebah Khan(219099073)
date: 27th March 2025*/

package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Statement;

import java.util.ArrayList;
import java.util.List;

public class StatementRepository implements IStatementRepository{
    private static StatementRepository repository;
    private List<Statement> statementList;

    private StatementRepository(){
        statementList = new ArrayList<Statement>();
    }

    public static StatementRepository getRepository(){
        if(repository == null){
            repository = new StatementRepository();
        }
        return repository;
    }

    public Statement create(Statement statement){
        statementList.add(statement);
        return statement;
    }

    public Statement read (String statementID){
        for(Statement statement : statementList){

            if(statement.getStatementID().equals(statementID)){
                return statement;
            }
        }
        return null;
    }

    public boolean delete (String statementID){
        Statement statement = read(statementID);
        if(statement != null){
            statementList.remove(statement);
            return true;
        }
        return false;
    }


    public void clear(){
        statementList.clear();
    }

    public List<Statement> getAll(){
        return statementList;
    }
}
