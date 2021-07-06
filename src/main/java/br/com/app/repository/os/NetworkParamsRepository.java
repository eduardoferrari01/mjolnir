package br.com.app.repository.os;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.os.NetworkParams;

public interface NetworkParamsRepository extends MongoRepository<NetworkParams,String>{

}
