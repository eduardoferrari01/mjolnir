package br.com.app.domain.builder.hardware;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.ComputerSystem;
import br.com.app.util.EntityBuilder;

public class ComputerSystemBuilder {

	private ColetaResultado coletaResultado;

	public ComputerSystemBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}

	public ComputerSystem builder() {

		ComputerSystem computerSystem = new EntityBuilder().builder(coletaResultado.getJson(), ComputerSystem.class);
		computerSystem.setId(coletaResultado.getId());
		return computerSystem;
	}
}
