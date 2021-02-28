package br.com.app.repository.os;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.os.OperatingSystem;

public interface OperatingSystemRepository extends MongoRepository<OperatingSystem,String> {

}
