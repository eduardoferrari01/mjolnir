package br.com.app.domain.builder.hardware;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.CentralProcessor;
import br.com.app.util.DomainBuilder;

public class CentralProcessorBuilder {

	private ColetaResultado coletaResultado;

	public CentralProcessorBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}

	public CentralProcessor builder() {

		CentralProcessor processor = new DomainBuilder().builder(coletaResultado.getJson(), CentralProcessor.class);
		processor.setId(coletaResultado.getId());
		return processor;
	}
}
