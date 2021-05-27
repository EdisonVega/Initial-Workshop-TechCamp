package sb.techcamp.bankapi.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.techcamp.bankapi.model.Account;
import sb.techcamp.bankapi.model.Client;
import sb.techcamp.bankapi.service.old.AccountService;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;


    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Get responses
    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> accounts = accountService.findAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Account> getAccountById (@PathVariable("id") Long id){
        Account account = accountService.findAccountById(id);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }
    @GetMapping("/findByClient/{clientId}")
    public ResponseEntity<List<Account>> getAccountByClientId(@PathVariable("clientId")  Long clientId){
        List<Account> accounts = accountService.findAccountByAccountClientId(clientId);
        return new ResponseEntity<>(accounts,HttpStatus.OK);
    }

    // Post responses
    @PostMapping("/add")
    public ResponseEntity<Account> addAccount(@RequestBody Account account){
        Account newAccount = accountService.addAccount(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    // Put responses
    @PostMapping("/update")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account){
        if(account.getAccountId() == null) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        else {
            Account updateAccount = accountService.updateAccount(account);
            return new ResponseEntity<>(updateAccount, HttpStatus.OK);
        }
    }

    // Delete responses
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Client> deleteAccount(@PathVariable("id") Long id){
        accountService.deleteAccountById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
