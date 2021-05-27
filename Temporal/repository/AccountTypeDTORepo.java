package sb.techcamp.bankapi.dto.repository;

import sb.techcamp.bankapi.dto.AccountTypeDTO;


import java.util.List;
import java.util.Optional;

public interface AccountTypeDTORepo {

    List<AccountTypeDTO> getAll();
    Optional<AccountTypeDTO> getById(Integer id);

    AccountTypeDTO add(AccountTypeDTO accountTypeDTO);
    AccountTypeDTO update(AccountTypeDTO accountTypeDTO);
    void delete(Integer id);

}
