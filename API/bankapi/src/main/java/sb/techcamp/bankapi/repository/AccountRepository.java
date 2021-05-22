package sb.techcamp.bankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.techcamp.bankapi.model.Account;
import sb.techcamp.bankapi.model.Client;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    public Optional<Account> findAccountByAccountClientId(Long clientId);
    public Optional<Account> findAccountByAccountId(long id);

    public void deleteAccountByAccountId(Long id);
    public void deleteAccountByAccountClientId(Long clientId);
}