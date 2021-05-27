package sb.techcamp.bankapi.service.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.techcamp.bankapi.exception.UserNotFoundException;
import sb.techcamp.bankapi.model.Transaction;
import sb.techcamp.bankapi.model.repository.TransactionRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // Find methods
    public List<Transaction> findAllTransactions(){
        return transactionRepository.findAll();
    }
    public List<Transaction> findTransactionByOrigin(Long orgId){
        return transactionRepository.findTransactionByTransactionOriginAccountId(orgId);
    }
    public List<Transaction> findTransactionByDest(Long orgId){
        return transactionRepository.findTransactionByTransactionDestAccountId(orgId);
    }
    public List<Transaction> findTransactionByDate(LocalDateTime date){
        return transactionRepository.findTransactionByTransactionDate(date);
    }
    public Transaction findTransactionById(Long id){
        return transactionRepository.findTransactionByTransactionId(id).
                orElseThrow(() -> new UserNotFoundException("Transaction with id " + id + " was not found"));
    }

    // add methods
    public Transaction addTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }
    // add methods
    public Transaction updateTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    // delete methods
    public void deleteTransaction(Long transactionId){
        transactionRepository.deleteTransactionByTransactionId(transactionId);
    }


}
