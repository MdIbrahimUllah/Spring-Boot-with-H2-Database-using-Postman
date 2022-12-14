package ca.vanier.amazoniaapi.service;

import java.util.List;
import java.util.Optional;

import ca.vanier.amazoniaapi.entity.Client;

public interface ClientService {

    // save
    Client saveClient(Client client);
    
    // read 
    List<Client> listClient();

    //update
    Client updateclient (Client client,  Long clientID);

    // delete

    void deleteClientID (Long ClientID);

    //find
    Optional<Client> findById (Long id);
}
