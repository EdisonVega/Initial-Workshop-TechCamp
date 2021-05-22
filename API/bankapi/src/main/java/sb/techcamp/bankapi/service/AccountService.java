package sb.techcamp.bankapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import sb.techcamp.bankapi.exception.UserNotFoundException;
import sb.techcamp.bankapi.model.Account;
import sb.techcamp.bankapi.repository.AccountRepository;

import java.util.List;

public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Add methods
    public Account addAccount(Account account){
        return accountRepository.save(account);
    }

    // Find methods
    public List<Account> findAllAccounts(){
        return accountRepository.findAll();
    }
    public Account findAccountById(Long id) {
        return accountRepository.findAccountByAccountId(id).
                orElseThrow(() -> new UserNotFoundException("Account with id " + id + " was not found"));
    }
    public Account findAccountByAccountClientId(Long clientId){
        return accountRepository.findAccountByAccountClientId(clientId).
                orElseThrow(() -> new UserNotFoundException("Account with client id " + clientId + " was not found"));
    }

    // Update methods
    public Account updateAccount(Account account){
        return accountRepository.save(account);
    }

    // Delete methods
    public void deleteAccountById(Long id){
        accountRepository.deleteAccountByAccountId(id);
    }
    public void deleteAccountByClientId(long clientId){
        accountRepository.deleteAccountByAccountClientId(clientId);
    }



}
