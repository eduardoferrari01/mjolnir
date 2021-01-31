package br.com.app.repository.config;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.ConfigAgente;

public interface ConfigAgenteRepository extends MongoRepository<ConfigAgente, String> {

	ConfigAgente findByHostName(String hostName);
}
