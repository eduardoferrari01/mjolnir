package br.com.app.domain.builder.hardware;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.Memory;
import br.com.app.util.EntityBuilder;

public class MemoryBuilder {

	private ColetaResultado coletaResultado;

	public MemoryBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}

	public Memory builder() {

		Memory memory = new EntityBuilder().builder(coletaResultado.getJson(), Memory.class);
		memory.setId(coletaResultado.getId());
		return memory;
	}
}
