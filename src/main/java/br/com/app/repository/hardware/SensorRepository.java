package br.com.app.repository.hardware;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.hardware.Sensor;

public interface SensorRepository extends MongoRepository<Sensor, String>{

}
