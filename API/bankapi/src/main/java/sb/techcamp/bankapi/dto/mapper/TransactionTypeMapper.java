package sb.techcamp.bankapi.dto.mapper;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import sb.techcamp.bankapi.dto.TransactionTypeDTO;
import sb.techcamp.bankapi.model.Transaction;
import sb.techcamp.bankapi.model.TransactionType;


@Mapper(componentModel = "spring")
public interface TransactionTypeMapper {

    @Mappings({

            @Mapping(target = "id", source = "transactionTypeId"),
            @Mapping(target = "name", source = "transactionTypeName")
    })
    TransactionTypeDTO toTransactionTypeDTO(Transaction transaction);

    @InheritInverseConfiguration
    TransactionType toTransactionType(TransactionTypeDTO transactionTypeDTO);


}
