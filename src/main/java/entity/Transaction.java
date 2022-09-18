package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "TRANSACTIONS")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTIONS_ID_SEQ")
    @SequenceGenerator(name = "TRANSACTIONS_ID_SEQ", allocationSize = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "DEBITED_ACCOUNT")
    private Account debitedAccount;

    @ManyToOne
    @JoinColumn(name = "CREDITED_ACCOUNT")
    private Account creditedAccount;

    @Basic
    private BigDecimal amount;

    @Version
    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getDebitedAccount() {
        return debitedAccount;
    }

    public void setDebitedAccount(Account debitedAccount) {
        this.debitedAccount = debitedAccount;
    }

    public Account getCreditedAccount() {
        return creditedAccount;
    }

    public void setCreditedAccount(Account creditedAccount) {
        this.creditedAccount = creditedAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
