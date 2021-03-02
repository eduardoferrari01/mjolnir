package br.com.app.repository.os;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.os.ServiceOS;
 
public interface ServiceOSRepository extends MongoRepository<ServiceOS,String>{

}
