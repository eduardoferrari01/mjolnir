package br.com.app.domain.builder.os;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.os.OSVersionInfo;
import br.com.app.util.DomainBuilder;

public class OSVersionInfoBuilder {

	private ColetaResultado coletaResultado;

	public OSVersionInfoBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}
	
	public OSVersionInfo builder() {

		OSVersionInfo osVersionInfo = new DomainBuilder().builder(coletaResultado.getJson(), OSVersionInfo.class);
		osVersionInfo.setId(coletaResultado.getId());
		return osVersionInfo;
	}
}
