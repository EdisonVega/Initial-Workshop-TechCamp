package sb.techcamp.bankapi.dto.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import sb.techcamp.bankapi.dto.BranchDTO;
import sb.techcamp.bankapi.dto.TransactionDTO;
import sb.techcamp.bankapi.model.Branch;
import sb.techcamp.bankapi.model.Transaction;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BranchMapper {

    @Mappings({

            @Mapping(target = "id", source = "branchId"),
            @Mapping(target = "name", source = "branchName"),
            @Mapping(target = "city", source = "branchCity"),
            @Mapping(target = "address", source = "branchAddress"),
            @Mapping(target = "openTime", source = "branchOpenTime"),
            @Mapping(target = "closeTime", source = "branchCloseTime")
    })
    BranchDTO toBranchDTO(Branch branch);
    List<BranchDTO> toBranchesDTO(List<Branch> branches);

    @InheritInverseConfiguration
    @Mapping(target = "transactions", ignore = true)
    Branch toBranch(BranchDTO branchDTO);

}
