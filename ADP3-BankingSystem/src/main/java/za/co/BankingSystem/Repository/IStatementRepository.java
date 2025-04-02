/*IStatementRepository.java
Statement Repository Interface
Author: Naqeebah Khan(219099073)
date: 27th March 2025*/


package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Statement;

import java.util.List;

public interface IStatementRepository {
    List<Statement> getAll();
}
