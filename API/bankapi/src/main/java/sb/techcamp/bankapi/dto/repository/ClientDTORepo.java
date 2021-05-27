package sb.techcamp.bankapi.dto.repository;

import sb.techcamp.bankapi.dto.ClientDTO;

import java.util.List;
import java.util.Optional;

public interface ClientDTORepo {

    List<ClientDTO> getAll();
    Optional<ClientDTO> getById(Long id);
    Optional<ClientDTO> getByEmail(String email);

    ClientDTO add(ClientDTO clientDTO);
    ClientDTO update(ClientDTO clientDTO);
    void delete(Long id);


}
