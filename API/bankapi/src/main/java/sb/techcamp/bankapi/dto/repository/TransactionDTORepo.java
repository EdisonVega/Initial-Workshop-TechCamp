package sb.techcamp.bankapi.dto.repository;

import sb.techcamp.bankapi.dto.TransactionDTO;
import sb.techcamp.bankapi.model.Transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TransactionDTORepo {

    List<TransactionDTO> getAll();
    Optional<TransactionDTO> getById(Long id);

    Optional<List<TransactionDTO>> getByOrigin(Long orgId);
    Optional<List<TransactionDTO>> getByDestination(Long destId);
    Optional<List<TransactionDTO>> getByDate(LocalDateTime date);

    TransactionDTO add(TransactionDTO transactionDTO);
    TransactionDTO update(TransactionDTO transactionDTO);
    void delete(Long transactionId);

}
