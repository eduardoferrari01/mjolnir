package br.com.app.repository.hardware;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.hardware.ComputerSystem;

public interface ComputerSystemRepository  extends MongoRepository<ComputerSystem, String> {

}
