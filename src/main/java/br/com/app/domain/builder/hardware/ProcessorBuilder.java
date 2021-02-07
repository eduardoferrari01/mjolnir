package br.com.app.domain.builder.hardware;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.Processor;
import br.com.app.util.EntityBuilder;

public class ProcessorBuilder {

	private ColetaResultado coletaResultado;

	public ProcessorBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}

	public Processor builder() {

		Processor processor = new EntityBuilder().builder(coletaResultado.getJson(), Processor.class);
		processor.setId(coletaResultado.getId());
		return processor;
	}
}
