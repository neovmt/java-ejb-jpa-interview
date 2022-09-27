package service;

import dto.AccountDto;
import entity.Account;
import entity.Transaction;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Stateless
public class AccountServiceImpl implements AccountService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<AccountDto> findCreditedAccountsByTransactionAmount(BigDecimal amount) {
        return entityManager.createNamedQuery(Transaction.Q_FIND_BY_AMOUNT, Transaction.class)
                .setParameter("amount", amount)
                .getResultList()
                .stream()
                .map(Transaction::getCreditedAccount)
                .map(o -> new AccountDto(o.getId(), o.getName(), o.getVersion()))
                .collect(Collectors.toSet());
    }

    @Override
    public void updateAccountName(Account account, String name) {
        Account entity = entityManager.find(Account.class, account.getId());
        entity.setName(name);
        entityManager.merge(entity);
        entityManager.clear();
    }
}
