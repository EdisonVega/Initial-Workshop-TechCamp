package sb.techcamp.bankapi.dto;

import lombok.Data;
import sb.techcamp.bankapi.model.Branch;
import sb.techcamp.bankapi.model.TransactionType;

import java.time.LocalDateTime;

@Data
public class TransactionDTO {

    private Long id;
    private Long branchId;
    private Integer typeId;
    private Long originAccountId;
    private Long destAccountId;
    private Double value;
    private Integer state; // 0: ERROR, 1: APPROVED, 2: PENDING
    private LocalDateTime date;

    private BranchDTO branch;
    private TransactionTypeDTO type;
    private AccountDTO origin;
    private AccountDTO destination;

}
