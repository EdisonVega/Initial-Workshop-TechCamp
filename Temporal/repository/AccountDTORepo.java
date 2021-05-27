package sb.techcamp.bankapi.dto.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import sb.techcamp.bankapi.dto.AccountDTO;


import java.util.List;
import java.util.Optional;

public interface AccountDTORepo {

    List<AccountDTO> getAll();
    Optional<AccountDTO> getById(Long  id);
    Optional<List<AccountDTO>> getByClient(Long clientId);

    AccountDTO add(AccountDTO accountDTO);
    AccountDTO update(AccountDTO accountDTO);
    void delete(Long accountId);

}
