package br.com.app.domain.builder.os;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.os.OSVersionInfo;
import br.com.app.util.EntityBuilder;

public class OSVersionInfoBuilder {

	private ColetaResultado coletaResultado;

	public OSVersionInfoBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}
	
	public OSVersionInfo builder() {

		OSVersionInfo osVersionInfo = new EntityBuilder().builder(coletaResultado.getJson(), OSVersionInfo.class);
		osVersionInfo.setId(coletaResultado.getId());
		return osVersionInfo;
	}
}
