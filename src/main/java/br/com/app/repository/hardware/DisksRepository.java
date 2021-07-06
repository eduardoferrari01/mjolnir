package br.com.app.repository.hardware;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.hardware.Disks;

public interface DisksRepository extends MongoRepository<Disks, String> {

}
