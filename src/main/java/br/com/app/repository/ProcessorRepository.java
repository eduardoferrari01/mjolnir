package br.com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.hardware.Processor;

public interface ProcessorRepository extends MongoRepository<Processor,String> {

}
