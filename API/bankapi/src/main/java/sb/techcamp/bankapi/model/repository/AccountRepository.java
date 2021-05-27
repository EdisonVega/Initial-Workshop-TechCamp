package sb.techcamp.bankapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import sb.techcamp.bankapi.model.Account;


import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Transactional(readOnly = true)
    Optional<Account> findAccountByAccountId(Long accountId);

    @Transactional(readOnly = true)
    List<Account> findAccountByAccountClientId(Long clientId);

    @Query("DELETE FROM Account a WHERE a.accountId = :accountId")
    void deleteAccountByAccountId(Long accountId);
}