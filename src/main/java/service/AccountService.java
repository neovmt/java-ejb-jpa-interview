package service;

import entity.Account;
import jakarta.ejb.Local;

@Local
public interface AccountService {

    /**
     * Update account name
     *
     * @param account
     * @param name
     */
    void updateAccountName(Account account, String name);
}
