package sb.techcamp.bankapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.techcamp.bankapi.model.AccountType;

import java.util.Optional;

public interface AccountTypeRepository extends JpaRepository<AccountType,Integer> {

    Optional<AccountType> findAccountTypeByAccountTypeId(Integer id);
    Optional<AccountType> findAccountTypeByAccountTypeName(String id);

    void deleteAccountTypeByAccountTypeId(Integer id);
}
