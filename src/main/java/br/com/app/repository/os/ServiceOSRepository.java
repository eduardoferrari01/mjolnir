package br.com.app.repository.os;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.os.Service;
 
public interface ServiceOSRepository extends MongoRepository<Service,String>{

}
