package br.com.app.repository.os;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.os.Sessions;

public interface SessionsRepository extends MongoRepository<Sessions,String>{

}
