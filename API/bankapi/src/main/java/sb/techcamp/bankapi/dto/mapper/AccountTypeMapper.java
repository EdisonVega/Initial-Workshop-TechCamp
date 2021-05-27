package sb.techcamp.bankapi.dto.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import sb.techcamp.bankapi.dto.AccountTypeDTO;
import sb.techcamp.bankapi.model.AccountType;

@Mapper(componentModel = "spring")
public interface AccountTypeMapper {

    @Mappings({

            @Mapping(target = "id", source = "accountTypeId"),
            @Mapping(target = "name", source = "accountTypeName")
    })
    AccountTypeDTO toAccountTypeDTO (AccountType accountType);

    @InheritInverseConfiguration
    AccountType toAccountType(AccountTypeDTO accountTypeDTO);
}
