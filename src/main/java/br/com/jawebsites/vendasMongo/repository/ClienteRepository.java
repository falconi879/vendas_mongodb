package br.com.jawebsites.vendasMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.jawebsites.vendasMongo.domain.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente,String> {

}
