package entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "ACCOUNTS")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNTS_ID_SEQ")
    @SequenceGenerator(name = "ACCOUNTS_ID_SEQ", allocationSize = 1)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "VERSION")
    @Version
    private Integer version;

    @OneToMany(mappedBy = "debitedAccount")
    private Set<Transaction> debitedTransactions;

    @OneToMany(mappedBy = "creditedAccount")
    private Set<Transaction> creditedTransactions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Transaction> getDebitedTransactions() {
        return debitedTransactions;
    }

    public void setDebitedTransactions(Set<Transaction> debitedTransactions) {
        this.debitedTransactions = debitedTransactions;
    }

    public Set<Transaction> getCreditedTransactions() {
        return creditedTransactions;
    }

    public void setCreditedTransactions(Set<Transaction> creditedTransactions) {
        this.creditedTransactions = creditedTransactions;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
