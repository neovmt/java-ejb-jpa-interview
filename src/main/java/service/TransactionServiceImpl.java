package service;

import entity.Account;
import entity.Transaction;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Stateless
public class TransactionServiceImpl implements TransactionService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Transaction> loadCreditedTransactions(Collection<Integer> accountIds) {
        List<Transaction> results = new ArrayList<>();

        for (Integer accountId : accountIds) {
            Account account = entityManager.find(Account.class, accountId);
            results.addAll(account.getCreditedTransactions());
        }

        return results;
    }

    @Override
    public void createTransaction(Account debitedAccount, Account creditedAccount, BigDecimal amount) {
        Transaction transaction = new Transaction();
        transaction.setDebitedAccount(entityManager.find(Account.class, debitedAccount.getId()));
        transaction.setCreditedAccount(entityManager.find(Account.class, creditedAccount.getId()));
        transaction.setAmount(amount);
        entityManager.persist(transaction);
        entityManager.clear();
    }
}
