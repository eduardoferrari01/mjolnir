package br.com.app.repository.os;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.os.OSVersionInfo;

public interface OSVersionInfoRepository extends MongoRepository<OSVersionInfo,String>{

}
