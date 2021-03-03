package br.com.app.domain.builder.os;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.os.OperatingSystem;
import br.com.app.util.DomainBuilder;

public class OperatingSystemBuilder {

	private ColetaResultado coletaResultado;

	public OperatingSystemBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}
	
	public OperatingSystem builder() {

		OperatingSystem operatingSystem = new DomainBuilder().builder(coletaResultado.getJson(), OperatingSystem.class);
		operatingSystem.setId(coletaResultado.getId());
		return operatingSystem;
	}
 
}
