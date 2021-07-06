package br.com.app.repository.hardware;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.hardware.NetworkIF;

public interface NetworkIFRepository extends MongoRepository<NetworkIF, String>{

}
