package br.com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.Network;

public interface NetworkIFRepository extends MongoRepository<Network, String>{

}
