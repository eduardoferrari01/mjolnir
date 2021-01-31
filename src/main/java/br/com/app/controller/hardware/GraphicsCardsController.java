package br.com.app.controller.hardware;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.GraphicsCard;
import br.com.app.domain.hardware.GraphicsCards;
import br.com.app.service.hardware.GraphicsCardsService;
import br.com.app.util.ConvertJson;

@RestController
@RequestMapping("/api/graphicscards")
public class GraphicsCardsController {

	private Logger logger = LoggerFactory.getLogger(GraphicsCardsController.class);
	
	@Autowired
	private GraphicsCardsService graphicsCardsService;
	
	@PostMapping
	public void post(@RequestBody ColetaResultado coletaResultado) {
		
		ConvertJson convertJson = new ConvertJson();
		List<Object> objects =   convertJson.jsonToListObject(coletaResultado.getJson(), GraphicsCard.class);
		
		GraphicsCards graphicsCards = new GraphicsCards();
		graphicsCards.setId(coletaResultado.getId());
		
		for (Object object : objects) {
			
			GraphicsCard graphicsCard = (GraphicsCard) object;
			graphicsCards.add(graphicsCard);
		
		}
		graphicsCardsService.save(graphicsCards);
	}
}
