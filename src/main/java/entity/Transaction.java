package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

import static entity.Transaction.Q_FIND_BY_AMOUNT;

@NamedQueries(
        @NamedQuery(name = Q_FIND_BY_AMOUNT,
                query = "select t from Transaction t where t.amount > :amount")
)
@Entity
@Table(name = "TRANSACTIONS")
public class Transaction {

    public static final String Q_FIND_BY_AMOUNT = "Transaction.Q_FIND_BY_AMOUNT";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTIONS_ID_SEQ")
    @SequenceGenerator(name = "TRANSACTIONS_ID_SEQ", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEBITED_ACCOUNT")
    private Account debitedAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREDITED_ACCOUNT")
    private Account creditedAccount;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Version
    @Column(name = "VERSION")
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
