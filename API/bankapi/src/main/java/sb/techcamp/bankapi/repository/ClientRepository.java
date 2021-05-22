package sb.techcamp.bankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.techcamp.bankapi.model.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    public void deleteClientByClientId(Long id);
    public Optional<Client> findClientByClientId(Long id);
}
