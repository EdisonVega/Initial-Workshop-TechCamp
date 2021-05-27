package sb.techcamp.bankapi.service.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.techcamp.bankapi.exception.UserNotFoundException;
import sb.techcamp.bankapi.model.Account;
import sb.techcamp.bankapi.model.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Find methods
    public List<Account> findAllAccounts(){
        return accountRepository.findAll();
    }
    public List<Account> findAccountByAccountClientId(Long clientId){
        return accountRepository.findAccountByAccountClientId(clientId);
    }
    public Account findAccountById(Long id) {
        return accountRepository.findAccountByAccountId(id).
                orElseThrow(() -> new UserNotFoundException("Account with id " + id + " was not found"));
    }


    // Add methods
    public Account addAccount(Account account){
        return accountRepository.save(account);
    }

    // Update methods
    public Account updateAccount(Account account){
        return accountRepository.save(account);
    }

    // Delete methods
    public void deleteAccountById(Long accountId){
        accountRepository.deleteAccountByAccountId(accountId);
    }

}
