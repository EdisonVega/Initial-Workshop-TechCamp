package sb.techcamp.bankapi.service.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.techcamp.bankapi.exception.UserNotFoundException;
import sb.techcamp.bankapi.model.Client;
import sb.techcamp.bankapi.model.repository.ClientRepository;

import java.util.List;


@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client addClient(Client client){
        return clientRepository.save(client);
    }
    public List<Client> findAllClients(){
        return clientRepository.findAll();
    }
    public Client updateClient(Client client){
        return clientRepository.save(client);
    }
    public Client findClientById(Long id) {
        return clientRepository.findClientByClientId(id).orElseThrow(() -> new UserNotFoundException("Client with id " + id + " was not found"));
    }
    public void deleteClient(Long id){
        clientRepository.deleteClientByClientId(id);
    }

}
