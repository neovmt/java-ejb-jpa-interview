package service;

import jakarta.ejb.Local;

@Local
public interface AccountService {

    /**
     * @param accountId
     * @param name
     */
    void updateAccountName(Integer accountId, String name);
}
