package br.com.app.repository.hardware;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.app.domain.hardware.GraphicsCards;

public interface GraphicsCardsRepository  extends MongoRepository<GraphicsCards, String>{

}
