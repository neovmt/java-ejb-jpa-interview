package service;

import entity.Account;
import entity.Transaction;
import jakarta.ejb.Local;

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
     * Check if transaction exists for given account
     *
     * @param account
     * @param transaction
     * @return
     */
    boolean transactionExists(Account account, Transaction transaction);
}
