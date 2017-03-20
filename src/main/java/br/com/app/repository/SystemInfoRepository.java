package br.com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.SystemInfo;

public interface SystemInfoRepository extends MongoRepository<SystemInfo,String> {

}
