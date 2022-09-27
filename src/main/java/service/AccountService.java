package service;

import dto.AccountDto;
import entity.Account;
import jakarta.ejb.Local;

import java.math.BigDecimal;
import java.util.Set;

@Local
public interface AccountService {

    /**
     * Find accounts with transaction's amount > amount
     *
     * @param amount
     * @return
     */
    Set<AccountDto> findCreditedAccountsByTransactionAmount(BigDecimal amount);

    /**
     * Update account name
     *
     * @param account
     * @param name
     */
    void updateAccountName(Account account, String name);
}
