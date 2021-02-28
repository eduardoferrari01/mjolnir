package br.com.app.repository.os;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.os.Processe;

public interface ProcesseRepository extends MongoRepository<Processe,String>{

}
