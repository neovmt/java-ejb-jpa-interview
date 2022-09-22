package service;

import entity.Account;
import entity.Transaction;
import jakarta.ejb.Local;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Local
public interface TransactionService {

    /**
     * Load all transactions by multiple account IDs
     *
     * @param accountIds
     * @return
     */
    List<Transaction> loadCreditedTransactions(Collection<Integer> accountIds);

    /**
     * Create transaction from debitedAccount to createTransaction
     *
     * @param debitedAccount
     * @param creditedAccount
     * @param amount
     */
    void createTransaction(Account debitedAccount, Account creditedAccount, BigDecimal amount);
}
