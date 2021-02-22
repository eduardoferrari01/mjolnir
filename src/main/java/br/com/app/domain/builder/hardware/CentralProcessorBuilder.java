package br.com.app.domain.builder.hardware;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.CentralProcessor;
import br.com.app.util.EntityBuilder;

public class CentralProcessorBuilder {

	private ColetaResultado coletaResultado;

	public CentralProcessorBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}

	public CentralProcessor builder() {

		CentralProcessor processor = new EntityBuilder().builder(coletaResultado.getJson(), CentralProcessor.class);
		processor.setId(coletaResultado.getId());
		return processor;
	}
}
