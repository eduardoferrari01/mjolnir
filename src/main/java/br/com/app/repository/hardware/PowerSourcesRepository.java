package br.com.app.repository.hardware;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.hardware.PowerSources;

public interface PowerSourcesRepository extends MongoRepository<PowerSources,String> {

}
