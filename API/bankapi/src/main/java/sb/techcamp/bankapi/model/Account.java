package sb.techcamp.bankapi.model;


import lombok.*;
import sb.techcamp.bankapi.model.AccountType;
import sb.techcamp.bankapi.model.Client;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long accountId;
    private Long accountClientId;
    private Integer accountTypeId;
    @Column(updatable = false)
    private LocalDateTime accountOpeningDate;
    private Double accountBalance;
    private Double accountCompRate;  // Taza de capitalizacion de la cuenta, puede ser 0
    private Double accountInterestBalance; // Intereses generados por la capitalizacion del saldo de forma diaria

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "iw_account_client_id_fk"), name = "accountClientId", insertable = false, updatable = false)
    private Client accountClient;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "iw_account_type_id_fk"), name = "accountTypeId", insertable = false, updatable = false)
    private AccountType accountType;


    @OneToMany(mappedBy = "originAccount")
    private List<Transaction> transactionsOrigin;

    @OneToMany(mappedBy = "destAccount")
    private List<Transaction> transactionsDest;

}
