package sb.techcamp.bankapi.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.techcamp.bankapi.model.Transaction;
import sb.techcamp.bankapi.service.old.TransactionService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        List<Transaction> transactions = transactionService.findAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
    @GetMapping("/byOrg/{orgId}")
    public ResponseEntity<List<Transaction>> getTransactionByOrigin(@PathVariable("orgId") Long orgId){
        List<Transaction> transactions = transactionService.findTransactionByOrigin(orgId);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
    @GetMapping("/byDest/{destId}")
    public ResponseEntity<List<Transaction>> getTransactionByDest(@PathVariable("destId") Long destId){
        List<Transaction> transactions = transactionService.findTransactionByDest(destId);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
    @GetMapping("/byDate/{date}")
    public ResponseEntity<List<Transaction>> getTransactionByDate(@PathVariable("date") LocalDateTime date){
        List<Transaction> transactions = transactionService.findTransactionByDate(date);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable("id") Long id){
        Transaction transaction = transactionService.findTransactionById(id);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction){
        Transaction newTransaction = transactionService.addTransaction(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction){
        if(transaction.getTransactionId() == null){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        else{
            Transaction updateTransaction = transactionService.updateTransaction(transaction);
            return new ResponseEntity<>(updateTransaction, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Transaction> deleteTransaction(@PathVariable("id") Long id){
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
