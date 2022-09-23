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
    public void updateAccountName(Account account, String name) {
        Account entity = entityManager.find(Account.class, account.getId());
        entity.setName(name);
        entityManager.merge(entity);
        entityManager.clear();
    }
}
