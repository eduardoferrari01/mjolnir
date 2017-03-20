package br.com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.NetworkIF;

public interface NetworkIFRepository extends MongoRepository<NetworkIF, String>{

}
