package sb.techcamp.bankapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.techcamp.bankapi.model.Transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findTransactionByTransactionId(Long id);

    List<Transaction> findTransactionByTransactionOriginAccountId(Long orgId);
    List<Transaction> findTransactionByTransactionDestAccountId(Long destId);
    List<Transaction> findTransactionByTransactionDate(LocalDateTime date);

    void deleteTransactionByTransactionId(Long transactionId);
}
