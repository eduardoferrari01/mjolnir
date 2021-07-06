package br.com.app.repository.hardware;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.hardware.Displays;

public interface DisplaysRepository extends  MongoRepository<Displays, String>{

}
