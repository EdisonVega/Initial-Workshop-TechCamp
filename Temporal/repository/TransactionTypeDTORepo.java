package sb.techcamp.bankapi.dto.repository;

import sb.techcamp.bankapi.dto.AccountTypeDTO;
import sb.techcamp.bankapi.dto.TransactionTypeDTO;

import java.util.List;
import java.util.Optional;

public interface TransactionTypeDTORepo {

    List<TransactionTypeDTO> getAll();
    Optional<TransactionTypeDTO> getById(Integer id);

    AccountTypeDTO add(AccountTypeDTO accountTypeDTO);
    AccountTypeDTO update(AccountTypeDTO accountTypeDTO);
    void delete(Integer id);
}
