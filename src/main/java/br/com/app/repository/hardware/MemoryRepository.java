package br.com.app.repository.hardware;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.hardware.Memory;

public interface MemoryRepository extends MongoRepository<Memory, String> {

}
