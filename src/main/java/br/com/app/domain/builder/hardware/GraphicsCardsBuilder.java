package br.com.app.domain.builder.hardware;

import java.util.List;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.GraphicsCard;
import br.com.app.domain.hardware.GraphicsCards;
import br.com.app.util.DomainBuilder;

public class GraphicsCardsBuilder {

	private ColetaResultado coletaResultado;

	public GraphicsCardsBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}

	public GraphicsCards builder() {

		GraphicsCards graphicsCards = new GraphicsCards();
		graphicsCards.setId(coletaResultado.getId());
		List<GraphicsCard> graphicsCard = new DomainBuilder().collectionBuilder(coletaResultado.getJson(), GraphicsCard.class);
		graphicsCards.setGraphicsCards(graphicsCard);
		return graphicsCards;
	}
}
