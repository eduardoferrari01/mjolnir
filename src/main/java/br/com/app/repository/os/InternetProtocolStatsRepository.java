package br.com.app.repository.os;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.os.InternetProtocolStats;

public interface InternetProtocolStatsRepository extends MongoRepository<InternetProtocolStats,String> {

}
