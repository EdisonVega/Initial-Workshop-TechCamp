package sb.techcamp.bankapi.dto.mapper;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import sb.techcamp.bankapi.dto.AccountDTO;
import sb.techcamp.bankapi.model.Account;

@Mapper(componentModel = "spring", uses = {ClientMapper.class,AccountTypeMapper.class})
public interface AccountMapper {

    @Mappings({

            @Mapping(target = "id", source = "accountId"),
            @Mapping(target = "clientId", source = "accountClientId"),
            @Mapping(target = "typeId", source = "accountTypeId"),
            @Mapping(target = "openingDate", source = "accountOpeningDate"),
            @Mapping(target = "balance", source = "accountBalance"),
            @Mapping(target = "compRate", source = "accountCompRate"),
            @Mapping(target = "interestBalance", source = "accountInterestBalance"),
            @Mapping(target = "client", source = "accountClient"),
            @Mapping(target = "type", source = "accountType")
    })
    AccountDTO toAccountDTO(Account account);

    @InheritInverseConfiguration
    @Mapping(target = "transactionsOrigin", ignore = true)
    @Mapping(target = "transactionsDest", ignore = true)
    Account toAccount(AccountDTO accountDTO);

}
