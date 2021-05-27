package sb.techcamp.bankapi.dto.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import sb.techcamp.bankapi.dto.TransactionDTO;
import sb.techcamp.bankapi.model.Transaction;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BranchMapper.class,AccountMapper.class, TransactionTypeMapper.class})
public interface TransactionMapper {


    @Mappings({
            @Mapping(target = "id", source = "transactionId"),
            @Mapping(target = "branchId", source = "transactionBranchId"),
            @Mapping(target = "typeId", source = "transactionTypeId"),
            @Mapping(target = "originAccountId", source = "transactionOriginAccountId"),
            @Mapping(target = "destAccountId", source = "transactionDestAccountId"),
            @Mapping(target = "value", source = "transactionValue"),
            @Mapping(target = "state", source = "transactionState"),
            @Mapping(target = "date", source = "transactionDate"),
            @Mapping(target = "branch", source = "transactionBranch"),
            @Mapping(target = "type", source = "transactionType"),
            @Mapping(target = "origin", source = "originAccount"),
            @Mapping(target = "destination", source = "destAccount")
    })
    TransactionDTO toTransactionDTO(Transaction transaction);
    List<TransactionDTO> toTransactionsDTO(List<Transaction> transactions);

    @InheritInverseConfiguration
    Transaction toTransaction(TransactionDTO transactionDTO);
}
