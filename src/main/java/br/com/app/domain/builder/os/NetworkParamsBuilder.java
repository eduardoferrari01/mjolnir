package br.com.app.domain.builder.os;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.os.NetworkParams;
import br.com.app.util.DomainBuilder;

public class NetworkParamsBuilder {

	private ColetaResultado coletaResultado;

	public NetworkParamsBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}
	
	public NetworkParams builder() {

		NetworkParams networkParams = new DomainBuilder().builder(coletaResultado.getJson(), NetworkParams.class);
		networkParams.setId(coletaResultado.getId());
		return networkParams;
	}
}
