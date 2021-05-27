package sb.techcamp.bankapi.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long transactionId;
    private Long transactionBranchId;
    private Integer transactionTypeId;
    private Long transactionOriginAccountId;
    private Long transactionDestAccountId;
    private Double transactionValue;
    private Integer transactionState; // 0: ERROR, 1: APPROVED, 2: PENDING
    private LocalDateTime transactionDate;


    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "iw_transaction_branch_id_fk"), name = "transactionBranchId", insertable = false, updatable = false)
    private Branch transactionBranch;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "iw_transaction_type_id_fk"), name = "transactionTypeId", insertable = false, updatable = false)
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "iw_transaction_origin_account_id_fk"), name = "transactionOriginAccountId", insertable = false, updatable = false)
    private Account originAccount;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "iw_transaction_dest_account_id_fk"), name = "transactionDestAccountId", insertable = false, updatable = false)
    private Account destAccount;

}
