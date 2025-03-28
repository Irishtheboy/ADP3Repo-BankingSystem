/*StatementFactoryTest.java
Statement Factory Test class
Author: Naqeebah Khan(219099073)
date: 27th March 2025*/

package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Statement;

import za.co.BankingSystem.Util.Helper;

import java.util.ArrayList;
import java.util.List;

public class StatementFactory {

    public static Statement createStatement(String statementID, String customerID, List<String> transactions, String statementDate) {



        if (statementID == null || customerID == null || transactions == null || statementDate == null) {
            throw new IllegalArgumentException("Invalid data provided for Statement creation");
        }
        //if (!Helper.validateStatement(statementID, customerID, transactions, statementDate)) {
          //  throw new IllegalArgumentException("Invalid data provided for Statement creation");
        //}

        if (transactions.isEmpty()){
            System.out.println("Empty transaction list");
        }


        return new Statement.Builder()
                .setStatementID(statementID)
                .setCustomerID(customerID)
                .setTransaction(transactions)
                .setStatementDate(statementDate)
                .build();
    }
}
