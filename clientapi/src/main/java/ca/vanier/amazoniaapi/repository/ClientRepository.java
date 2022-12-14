package ca.vanier.amazoniaapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.vanier.amazoniaapi.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository <Client, Long>{  // <entity name, primary key variable type>
    
}
