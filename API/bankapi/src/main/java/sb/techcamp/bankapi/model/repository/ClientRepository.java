package sb.techcamp.bankapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.techcamp.bankapi.model.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findClientByClientId(Long id);

    void deleteClientByClientId(Long id);

}
