package sb.techcamp.bankapi.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.techcamp.bankapi.model.Client;
import sb.techcamp.bankapi.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients (){
        List<Client> clients = clientService.findAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Client> getClientById (@PathVariable("id") Long id){
        Client client = clientService.findClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        Client newClient = clientService.addClient(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client){
        if(client.getClientId() == null) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        else {
            Client updateClient = clientService.updateClient(client);
            return new ResponseEntity<>(updateClient, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable("id") Long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
