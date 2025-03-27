package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Statement;

import java.util.List;

public interface IStatementRepository {
    List<Statement> getAll();
}
