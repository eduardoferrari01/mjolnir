package br.com.app.domain.hardware;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class GraphicsCards {

	@Id
	private String id;
	
	private List<GraphicsCard> graphicsCards;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<GraphicsCard> getGraphicsCards() {
		return graphicsCards;
	}

	public void setGraphicsCards(List<GraphicsCard> graphicsCards) {
		this.graphicsCards = graphicsCards;
	}
	
	public void add(GraphicsCard graphicsCard) {
		
		if(graphicsCards == null) {
			graphicsCards = new ArrayList<GraphicsCard>();
		}
		
		graphicsCards.add(graphicsCard);
	}
}
