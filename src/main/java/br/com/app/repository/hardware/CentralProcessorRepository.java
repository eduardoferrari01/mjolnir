package br.com.app.repository.hardware;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.hardware.CentralProcessor;

public interface CentralProcessorRepository extends MongoRepository<CentralProcessor,String> {

}
