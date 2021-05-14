package br.com.app.repository.config;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.Agente;

public interface AgenteRepository extends MongoRepository<Agente, String> {

	Agente findByHostName(String hostName);
}
