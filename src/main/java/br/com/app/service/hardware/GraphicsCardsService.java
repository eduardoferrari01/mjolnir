package br.com.app.service.hardware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.domain.hardware.GraphicsCards;
import br.com.app.repository.hardware.GraphicsCardsRepository;

@Service
public class GraphicsCardsService {

	@Autowired
	private GraphicsCardsRepository graphicsCardsRepository;
	
	public void save(GraphicsCards graphicsCards) {
		
		graphicsCardsRepository.save(graphicsCards);
		
	}
}
