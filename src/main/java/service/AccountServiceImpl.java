package service;

import entity.Account;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class AccountServiceImpl implements AccountService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void updateAccountName(Integer accountId, String name) {
        Account account = entityManager.find(Account.class, accountId);
        account.setName(name);
    }
}
