package br.com.app.domain.builder.hardware;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.ComputerSystem;
import br.com.app.util.DomainBuilder;

public class ComputerSystemBuilder {

	private ColetaResultado coletaResultado;

	public ComputerSystemBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}

	public ComputerSystem builder() {

		ComputerSystem computerSystem = new DomainBuilder().builder(coletaResultado.getJson(), ComputerSystem.class);
		computerSystem.setId(coletaResultado.getId());
		return computerSystem;
	}
}
